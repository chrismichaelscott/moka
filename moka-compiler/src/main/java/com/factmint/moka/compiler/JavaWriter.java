package com.factmint.moka.compiler;

import java.io.StringWriter;

import com.factmint.moka.compiler.helper.FeatureMapperHelper;
import com.factmint.moka.compiler.model.MokaClass;
import com.factmint.moka.compiler.model.MokaConstant;
import com.factmint.moka.compiler.model.MokaMethod;
import com.factmint.moka.compiler.model.MokaVariable;

public class JavaWriter {
	
	private StringWriter writer = new StringWriter();

	public JavaWriter(MokaClass mokaClass) {
		
		FeatureMapperHelper featureMapper = new FeatureMapperHelper(mokaClass);
		featureMapper.buildGettersAndSetters();
		featureMapper.provideMethodsWithSignaturesToSatisfyDefaultValues();
		
		writeImports(mokaClass);
		
		writeClassStart(mokaClass);
		
		writeConstants(mokaClass);
		
		writeDependencies(mokaClass);
		
		writeFields(mokaClass);
		
		writeExplicitContructors(mokaClass);
		
		writeConstructConstructors(mokaClass);
		
		writeMethods(mokaClass);
		
		writeClassEnd();
	}

	private void writeImports(MokaClass mokaClass) {
		for (String importClass : mokaClass.getImports()) {
			writer.write("import " + importClass + ";\nO");
		}
		if (!mokaClass.getImports().isEmpty()) {
			writer.write("\n");
		}
	}

	private void writeClassStart(MokaClass mokaClass) {
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
	}

	private void writeConstants(MokaClass mokaClass) {
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
	}

	private void writeDependencies(MokaClass mokaClass) {
		for (MokaVariable dependency : mokaClass.getDependencies()) {
			writer.write("\tprivate " + dependency.getType() + " " + dependency.getName() + ";\n");
		}
		if (! mokaClass.getDependencies().isEmpty()) {			
			writer.write("\t\n");
		}
	}

	private void writeFields(MokaClass mokaClass) {
		for (MokaVariable field : mokaClass.getFields()) {
			writer.write("\tprivate " + field.getType() + " " + field.getName() + ";\n");
		}
		if (! mokaClass.getFields().isEmpty()) {			
			writer.write("\t\n");
		}
	}

	private void writeExplicitContructors(MokaClass mokaClass) {
		for (MokaMethod explicitConstructor : mokaClass.getExplicitConstructors()) {
			writer.write("\t" + explicitConstructor.getVisibility().toString().toLowerCase() + " " + explicitConstructor.getName() + "(");
			writeMethodArguments(explicitConstructor);
			writer.write(") {\n");
			
			writer.write(explicitConstructor.getContents());
			writer.write("\n\t}\n\t\n");
		}
	}

	private void writeConstructConstructors(MokaClass mokaClass) {
		for (MokaMethod constructors : mokaClass.getConstructors()) {
			writer.write("\t" + constructors.getVisibility().toString().toLowerCase() + " " + constructors.getReturnType() + " " + constructors.getName() + "(");
			writeMethodArguments(constructors);
			writer.write(") {\n");
			
			writer.write(constructors.getContents());
			writer.write("\n\t}\n\t\n");
		}
	}

	private void writeMethods(MokaClass mokaClass) {
		for (MokaMethod method : mokaClass.getMethods()) {
			writer.write("\t" + method.getVisibility().toString().toLowerCase() + " " + method.getReturnType() + " " + method.getName() + "(");
			writeMethodArguments(method);
			writer.write(") {\n");
			
			writer.write(method.getContents());
			writer.write("\n\t}\n\t\n");
		}
	}
	
	private void writeClassEnd() {
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
