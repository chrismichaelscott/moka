package com.factmint.lang;

import java.io.StringWriter;

import com.factmint.lang.model.LangClass;
import com.factmint.lang.model.LangMember;
import com.factmint.lang.model.LangMethod;
import com.factmint.lang.model.LangVariable;
import com.factmint.lang.model.LangMember.Visibility;

public class JavaWriter {
	
	private StringWriter writer = new StringWriter();

	public JavaWriter(LangClass langClass) {
		
		for (LangVariable dependency : langClass.getDependencies()) {
			boolean hasGetter = false;
			boolean hasSetter = false;
			
			String getterName = "get" + dependency.getName().substring(0, 1).toUpperCase() + dependency.getName().substring(1);
			String setterName = "set" + dependency.getName().substring(0, 1).toUpperCase() + dependency.getName().substring(1);

			for (LangMethod method : langClass.getMethods()) {
				if (
						method.getName().equals(getterName) &&
						method.getReturnType().equals(dependency.getType()) &&
						method.getVisibility().equals(LangMember.Visibility.PUBLIC) &&
						method.getArguments().size() == 0) { 
					hasGetter = true;
				}
				
				if (
						method.getName().equals(setterName) &&
						method.getReturnType().equals(void.class.getName()) &&
						method.getVisibility().equals(LangMember.Visibility.PUBLIC) &&
						method.getArguments().size() == 1 &&
						method.getArguments().get(0).getType().equals(dependency.getType())) { 
					hasSetter = true;
				}
				
				if (hasGetter && hasSetter) break;
			}
			
			if (! hasGetter) {
				langClass.getMethods().add(LangMethod.getDefaultGetter(getterName, dependency));
			}
			
			if (! hasSetter) {
				langClass.getMethods().add(LangMethod.getDefaultSetter(setterName, dependency));
			}
		}
		
		for (String importClass : langClass.getImports()) {
			writer.write("import " + importClass + ";\nO");
		}
		if (!langClass.getImports().isEmpty()) {
			writer.write("\n");
		}
		
		writer.write("public class " + langClass.getName());
		
		if (! langClass.getSuperClass().equals("Object")) {
			writer.write(" extends " + langClass.getSuperClass());
		}
		
		if (langClass.getImplementedInerfaces().size() > 0) {
			writer.write(" implements");
		}
		boolean firstImplementedInterface = true;
		for (String implementedInterface : langClass.getImplementedInerfaces()) {
			if (firstImplementedInterface) {
				firstImplementedInterface = false;
			} else {
				writer.write(",");
			}
			writer.write(" " + implementedInterface);
		}
		
		writer.write(" {\n\t\n");
		
		for (LangVariable dependency : langClass.getDependencies()) {
			writer.write("\tprivate " + dependency.getType() + " " + dependency.getName() + ";\n");
		}
		if (! langClass.getDependencies().isEmpty()) {			
			writer.write("\t\n");
		}
		
		for (LangVariable field : langClass.getFields()) {
			writer.write("\tprivate " + field.getType() + " " + field.getName() + ";\n");
		}
		if (! langClass.getFields().isEmpty()) {			
			writer.write("\t\n");
		}
		
		for (LangMethod constructor : langClass.getConstructors()) {
			writer.write("\t" + constructor.getVisibility().toString().toLowerCase() + " " + langClass.getName() + "(");
			writeMethodArguments(constructor);
			writer.write(") {\n");
			
			writer.write("\t\tconstruct(");
			writeMethodCallArguments(constructor);
			writer.write(");\n");
			writer.write("\t}\n\t\n");
			
			// The constructor is also in the methods list, make it private there
			constructor.setVisibility(Visibility.PRIVATE);
		}
		
		for (LangMethod method : langClass.getMethods()) {
			writer.write("\t" + method.getVisibility().toString().toLowerCase() + " " + method.getReturnType() + " " + method.getName() + "(");
			writeMethodArguments(method);
			writer.write(") {\n");
			
			writer.write(method.getContents());
			writer.write("\n\t}\n\t\n");
		}
		
		writer.write("}");
	}

	private void writeMethodArguments(LangMethod method) {
		boolean firstArgument = true;
		
		for (LangVariable argument : method.getArguments()) {
			if (firstArgument) {
				firstArgument = false;
			} else {
				writer.write(", ");
			}
			writer.write(argument.getType() + " " + argument.getName());
		}
	}

	private void writeMethodCallArguments(LangMethod method) {
		boolean firstArgument = true;
		
		for (LangVariable argument : method.getArguments()) {
			if (firstArgument) {
				firstArgument = false;
			} else {
				writer.write(", ");
			}
			writer.write(argument.getName());
		}
	}
	
	@Override
	public String toString() {
		return writer.toString();
	}

}
