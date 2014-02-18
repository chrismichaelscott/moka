package com.factmint.moka.compiler;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.factmint.moka.compiler.model.MokaClass;
import com.factmint.moka.compiler.model.MokaConstant;
import com.factmint.moka.compiler.model.MokaMember;
import com.factmint.moka.compiler.model.MokaMethod;
import com.factmint.moka.compiler.model.MokaMethodVariable;
import com.factmint.moka.compiler.model.MokaVariable;

public class JavaWriter {
	
	private StringWriter writer = new StringWriter();

	public JavaWriter(MokaClass mokaClass) {
		
		for (MokaVariable dependency : mokaClass.getDependencies()) {
			boolean hasGetter = false;
			boolean hasSetter = false;
			
			String getterName = "get" + dependency.getName().substring(0, 1).toUpperCase() + dependency.getName().substring(1);
			String setterName = "set" + dependency.getName().substring(0, 1).toUpperCase() + dependency.getName().substring(1);

			for (MokaMethod method : mokaClass.getMethods()) {
				if (
						method.getName().equals(getterName) &&
						method.getReturnType().equals(dependency.getType()) &&
						method.getVisibility().equals(MokaMember.Visibility.PUBLIC) &&
						method.getArguments().size() == 0) { 
					hasGetter = true;
				}
				
				if (
						method.getName().equals(setterName) &&
						method.getReturnType().equals(void.class.getName()) &&
						method.getVisibility().equals(MokaMember.Visibility.PUBLIC) &&
						method.getArguments().size() == 1 &&
						method.getArguments().get(0).getType().equals(dependency.getType())) { 
					hasSetter = true;
				}
				
				if (hasGetter && hasSetter) break;
			}
			
			if (! hasGetter) {
				mokaClass.getMethods().add(MokaMethod.getDefaultGetter(getterName, dependency));
			}
			
			if (! hasSetter) {
				mokaClass.getMethods().add(MokaMethod.getDefaultSetter(setterName, dependency));
			}
		}
		
		List<MokaMethod> wrapperMethods = new ArrayList<MokaMethod>();
		
		List<MokaMethod> argumentSortedMethods = new ArrayList<MokaMethod>();
		argumentSortedMethods.addAll(mokaClass.getMethods());
		
		Collections.sort(argumentSortedMethods, new Comparator<MokaMethod>() {
			public int compare(MokaMethod a, MokaMethod b) {
				return b.getArguments().size() - a.getArguments().size();
			}
		});
		
		for (MokaMethod method : argumentSortedMethods) {
			List<MokaMethodVariable> requiredParameters = new ArrayList<MokaMethodVariable>();
			List<MokaMethodVariable> optionalParameters = new ArrayList<MokaMethodVariable>();
			
			for (MokaMethodVariable argument : method.getArguments()) {
				if (argument.getDefaultValue() == null) {
					requiredParameters.add(argument);
				} else {
					optionalParameters.add(argument);
				}
			}
			
			List<List<Integer>> indexesOfDefaultsToProvide = new ArrayList<List<Integer>>();
			for (int numberOfDefaultsRequiredThisIteration = 1; numberOfDefaultsRequiredThisIteration <= optionalParameters.size(); numberOfDefaultsRequiredThisIteration++) {
				
				List<List<Integer>> indexesOfDefaultsToProvideOfLengthN = new ArrayList<List<Integer>>();
				for (int x = 0; x < numberOfDefaultsRequiredThisIteration; x++) {
					addDistinctNthTerms(indexesOfDefaultsToProvideOfLengthN, optionalParameters.size() - 1);
				}
				indexesOfDefaultsToProvide.addAll(indexesOfDefaultsToProvideOfLengthN);
			}
			
			for (List<Integer> indexesToMakeDefault : indexesOfDefaultsToProvide) {
				MokaMethod wrapperMethod = new MokaMethod();
				
				wrapperMethod.setName(method.getName());
				wrapperMethod.setReturnType(method.getReturnType());
				
				List<MokaMethodVariable> wrapperArgumentsToDefault = new ArrayList<MokaMethodVariable>();
				for (int index = 0; index < optionalParameters.size(); index++) {
					if (indexesToMakeDefault.contains(index)) {
						wrapperArgumentsToDefault.add(optionalParameters.get(index));
					}
				}
				
				for (MokaMethodVariable methodArgument : method.getArguments()) {
					if (! wrapperArgumentsToDefault.contains(methodArgument)) {
						wrapperMethod.getArguments().add(methodArgument);
					}
				}
								
				String wrapperBody = "\t\t";
				if (! method.getReturnType().equals(void.class.getName())) {
					wrapperBody += "return ";
				}
				wrapperBody += method.getName() + "(";
				
				boolean first = true;
				for (MokaMethodVariable methodArgument : method.getArguments()) {
					if (first) {
						first = false;
					} else {
						wrapperBody += ", ";
					}
					if (wrapperArgumentsToDefault.contains(methodArgument)) {
						if (methodArgument.getDefaultValue().equals("null")) {
							wrapperBody += "null";
						} else if (methodArgument.getDefaultValue().equals("new")) {
							wrapperBody += "new " + methodArgument.getType() + "()";
						} else {
							wrapperBody += methodArgument.getDefaultValue();
						}
					} else {
						wrapperBody += methodArgument.getName();
					}
				}
				
				wrapperBody += ");";
				
				wrapperMethod.setContents(wrapperBody);
				
				wrapperMethods.add(wrapperMethod);
			}
		}
		
		for (MokaMethod wrapperMethod : wrapperMethods) {
			if (! mokaClass.containsMethodWithMatchingSignature(wrapperMethod)) {
				mokaClass.getMethods().add(wrapperMethod);
			}
		}
		
		for (String importClass : mokaClass.getImports()) {
			writer.write("import " + importClass + ";\nO");
		}
		if (!mokaClass.getImports().isEmpty()) {
			writer.write("\n");
		}
		
		writer.write("public class " + mokaClass.getName());
		
		if (! mokaClass.getSuperClass().equals("Object")) {
			writer.write(" extends " + mokaClass.getSuperClass());
		}
		
		if (mokaClass.getImplementedInterfaces().size() > 0) {
			writer.write(" implements");
		}
		boolean firstImplementedInterface = true;
		for (String implementedInterface : mokaClass.getImplementedInterfaces()) {
			if (firstImplementedInterface) {
				firstImplementedInterface = false;
			} else {
				writer.write(",");
			}
			writer.write(" " + implementedInterface);
		}
		
		writer.write(" {\n\t\n");
		
		String staticInitializers = "";
		
		for (MokaConstant constant : mokaClass.getConstants()) {
			writer.write("\tpublic static " + constant.getType() + " " + constant.getName());
			if (! constant.getInitialValue().isEmpty()) {
				writer.write(" = " + constant.getInitialValue());
			}
			writer.write(";\n");
			
			if (! constant.getInitializationBody().isEmpty()) {
				staticInitializers += constant.getInitializationBody() + "\n";
			}
		}
		if (! mokaClass.getConstants().isEmpty()) {			
			writer.write("\t\n");
		}
		
		if (!staticInitializers.isEmpty()) {
			writer.write("\tstatic {\n");
			writer.write(staticInitializers);
			writer.write("\t}\n\t\n");
		}
		
		for (MokaVariable dependency : mokaClass.getDependencies()) {
			writer.write("\tprivate " + dependency.getType() + " " + dependency.getName() + ";\n");
		}
		if (! mokaClass.getDependencies().isEmpty()) {			
			writer.write("\t\n");
		}
		
		for (MokaVariable field : mokaClass.getFields()) {
			writer.write("\tprivate " + field.getType() + " " + field.getName() + ";\n");
		}
		if (! mokaClass.getFields().isEmpty()) {			
			writer.write("\t\n");
		}
		
		for (MokaMethod explicitConstructor : mokaClass.getExplicitConstructors()) {
			writer.write("\t" + explicitConstructor.getVisibility().toString().toLowerCase() + " " + explicitConstructor.getName() + "(");
			writeMethodArguments(explicitConstructor);
			writer.write(") {\n");
			
			writer.write(explicitConstructor.getContents());
			writer.write("\n\t}\n\t\n");
		}
		
		for (MokaMethod constructors : mokaClass.getConstructors()) {
			writer.write("\t" + constructors.getVisibility().toString().toLowerCase() + " " + constructors.getReturnType() + " " + constructors.getName() + "(");
			writeMethodArguments(constructors);
			writer.write(") {\n");
			
			writer.write(constructors.getContents());
			writer.write("\n\t}\n\t\n");
		}
		
		for (MokaMethod method : mokaClass.getMethods()) {
			writer.write("\t" + method.getVisibility().toString().toLowerCase() + " " + method.getReturnType() + " " + method.getName() + "(");
			writeMethodArguments(method);
			writer.write(") {\n");
			
			writer.write(method.getContents());
			writer.write("\n\t}\n\t\n");
		}
		
		writer.write("}");
	}
	
	private void addDistinctNthTerms(List<List<Integer>> existingLists, int maximumIndex) {
		if (existingLists.size() == 0) {
			for (int x = maximumIndex; x >= 0; x--) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(x);
				
				existingLists.add(list);
			}
		} else {
			List<List<Integer>> listsToAdd = new ArrayList<List<Integer>>();
			List<List<Integer>> listsToRemove = new ArrayList<List<Integer>>();
			
			for (List<Integer> existingList : existingLists) {
				int lastIndex = existingList.get(existingList.size() - 1);
				
				if (lastIndex != 0) {
					for (int nextIndex = lastIndex - 1; nextIndex >= 0; nextIndex--) {
						List<Integer> nextList = new ArrayList<Integer>();
						nextList.addAll(existingList);
						nextList.add(nextIndex);
						listsToAdd.add(nextList);
					}
				}
				listsToRemove.add(existingList);
			}
			
			existingLists.addAll(listsToAdd);
			existingLists.removeAll(listsToRemove);
		}
	}

	private void writeMethodArguments(MokaMethod method) {
		boolean firstArgument = true;
		
		for (MokaVariable argument : method.getArguments()) {
			if (firstArgument) {
				firstArgument = false;
			} else {
				writer.write(", ");
			}
			writer.write(argument.getType() + " " + argument.getName());
		}
	}
	
	@Override
	public String toString() {
		return writer.toString();
	}

}
