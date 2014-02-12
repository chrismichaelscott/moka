package com.factmint.moka.compiler;

import java.io.StringWriter;

import com.factmint.moka.compiler.model.MokaClass;
import com.factmint.moka.compiler.model.MokaMember;
import com.factmint.moka.compiler.model.MokaMethod;
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
