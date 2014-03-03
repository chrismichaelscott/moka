package com.factmint.moka.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.factmint.moka.compiler.exception.CompilationException;
import com.factmint.moka.compiler.model.MokaClass;
import com.factmint.moka.compiler.model.MokaConstant;
import com.factmint.moka.compiler.model.MokaMethodVariable;
import com.factmint.moka.compiler.model.MokaMember.Visibility;
import com.factmint.moka.compiler.model.MokaMethod;
import com.factmint.moka.compiler.model.MokaVariable;

public class TransCompiler {

	private Charset charSet;
	
	public TransCompiler() {
		this.charSet = Charset.forName("UTF-8");
	}
	
	public TransCompiler(Charset charSet) {
		this.charSet = charSet;
	}

	public String compile(File mokaFile) throws CompilationException, FileNotFoundException {
		
		MokaClass mokaClass = createJavaClassFromMokaClassFile(mokaFile);
		
		parseMokaClassFile(mokaFile, mokaClass);
		
		return new JavaWriter(mokaClass).toString();
	}

	private void parseMokaClassFile(File mokaFile, MokaClass mokaClass) throws FileNotFoundException, CompilationException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(mokaFile), charSet));
		
		boolean finished = false;
		do {
			try {
				String token = Tokenizer.readNextToken(reader);
				
				processToken(token, mokaClass, reader);
			} catch (EndOfStreamNotification e) {
				finished  = true;
			}
			
		} while (! finished);
	}

	private MokaClass createJavaClassFromMokaClassFile(File mokaFile) {
		MokaClass mokaClass = new MokaClass();
		mokaClass.setName(mokaFile.getName().replaceAll(".moka$", ""));
		return mokaClass;
	}
	
	private void processToken(String token, MokaClass mokaClass, BufferedReader reader) throws CompilationException {
		if (token.equals("import")) {
			
			processImportDeclaration(mokaClass, reader);

		} else if (token.equals("constant")) {
			
			processConstantDeclaration(mokaClass, reader);
			
		} else if (token.equals("dependency")) {
			
			processDependencyDeclaration(mokaClass, reader);

		} else if (token.equals("field")) {
			
			processFieldDeclaration(mokaClass, reader);

		} else {
			
			processMethodDeclaration(token, mokaClass, reader);

		}
	}

	private void processImportDeclaration(MokaClass mokaClass, BufferedReader reader) throws CompilationException {
		String importClass;
		try {
			importClass = Tokenizer.readNextToken(reader);
		} catch (EndOfStreamNotification e) {
			throw new CompilationException("Reached the end of the file without finding the class to import");
		}
		mokaClass.getImports().add(importClass );
		
		Tokenizer.checkForLineTermination(reader);
	}

	private void processConstantDeclaration(MokaClass mokaClass, BufferedReader reader) throws CompilationException {
		String constantType;
		try {
			constantType = Tokenizer.readNextToken(reader);
		} catch (EndOfStreamNotification e) {
			throw new CompilationException("Reached the end of the file without finding the constant type");
		}

		String constantName;
		try {
			constantName = Tokenizer.readNextToken(reader);
		} catch (EndOfStreamNotification e) {
			throw new CompilationException("Reached the end of the file without finding the constant name");
		}
		
		String body = "";
		String initialValue = "";
		
		try {
			Tokenizer.absorbWhitespace(reader);
			char nextChar = Tokenizer.readNextChar(reader);
			
			if (nextChar == '=') {
				Tokenizer.absorbWhitespace(reader);
				nextChar = Tokenizer.readNextChar(reader);
				while(nextChar != ';') {
					initialValue += nextChar;
					nextChar = Tokenizer.readNextChar(reader);
				}
				Tokenizer.reset(reader);
			} else if (nextChar == '{') {			
				Tokenizer.reset(reader);
				body = indentAndFormatMethodBody(readMethodBody(reader, constantName + "_STATIC_SETTER").replaceAll("[^\n][ 	]*define[ 	]+", "	" + constantName + " = "));
			} else {
				throw new CompilationException("Error parsing constant definition for " + constantName + " expected \"=\" or \"{\" but found " + nextChar);
			}
		} catch (IOException e) {
			throw new CompilationException(e);
		} catch (EndOfStreamNotification e) {
			throw new CompilationException("Reached the end of the file prematurely");
		}
		
		mokaClass.getConstants().add(MokaConstant.create(constantType, constantName, initialValue, body));
		
		Tokenizer.checkForLineTermination(reader);
	}

	private void processDependencyDeclaration(MokaClass mokaClass, BufferedReader reader) throws CompilationException {
		String dependencyType;
		try {
			dependencyType = Tokenizer.readNextToken(reader);
		} catch (EndOfStreamNotification e) {
			throw new CompilationException("Reached the end of the file without finding the dependency type");
		}

		String dependencyName;
		try {
			dependencyName = Tokenizer.readNextToken(reader);
		} catch (EndOfStreamNotification e) {
			throw new CompilationException("Reached the end of the file without finding the dependency name");
		}
		
		mokaClass.getDependencies().add(MokaVariable.create(dependencyType, dependencyName));
		
		Tokenizer.checkForLineTermination(reader);
	}

	private void processFieldDeclaration(MokaClass mokaClass, BufferedReader reader) throws CompilationException {
		String fieldType;
		try {
			fieldType = Tokenizer.readNextToken(reader);
		} catch (EndOfStreamNotification e) {
			throw new CompilationException("Reached the end of the file without finding the field type");
		}

		String fieldName;
		try {
			fieldName = Tokenizer.readNextToken(reader);
		} catch (EndOfStreamNotification e) {
			throw new CompilationException("Reached the end of the file without finding the field name");
		}
		
		mokaClass.getFields().add(MokaVariable.create(fieldType, fieldName));
		
		Tokenizer.checkForLineTermination(reader);
	}

	private void processMethodDeclaration(String token, MokaClass mokaClass,
			BufferedReader reader) throws CompilationException {
		MokaMethod method = new MokaMethod();
		
		readMethodNameAndModifiers(token, reader, method);
		
		token = readMethodArguments(token, reader, method);
		
		String content = readMethodBody(reader, method.getName());
		
		method.setContents(indentAndFormatMethodBody(content));
		
		if (method.getName().equals(mokaClass.getName())) {
			checkForConstructorConflict(mokaClass, method);
			
			mokaClass.getExplicitConstructors().add(method);
		} else if (method.getName().equals("construct")) {
			defineConstructConstructor(mokaClass, method);
		} else {			
			mokaClass.getMethods().add(method);
		}
		
	}

	private void readMethodNameAndModifiers(String firstToken,
			BufferedReader reader, MokaMethod method)
			throws CompilationException {
		
		String[] tokens = getMethodNameAndModifierTokens(firstToken, reader);
		
		Visibility visibility = Visibility.PUBLIC;
		String returnType = void.class.getName();
		String methodName = "";
		Boolean isStatic = false;
		Boolean isFinal = false;
		
		int cursor = tokens.length - 1;
		
		methodName = tokens[cursor--];

		boolean hadReturnType = false;
		boolean hadVisibilityModifier = false;
		while (cursor >= 0) {
			String modifier = tokens[cursor--];
			
			if (modifier.equals("public")) {
				if (hadVisibilityModifier) {
					throw new CompilationException("Found two visibility modifiers");
				}
				
				visibility = Visibility.PUBLIC;
			} else if (modifier.equals("protected")) {
				if (hadVisibilityModifier) {
					throw new CompilationException("Found two visibility modifiers");
				}
				
				visibility = Visibility.PROTECTED;
			} else if (modifier.equals("private")) {
				if (hadVisibilityModifier) {
					throw new CompilationException("Found two visibility modifiers");
				}
				
				visibility = Visibility.PRIVATE;
			} else if (modifier.equals("static")) {
				if (isStatic) {
					throw new CompilationException("Method is defined as static twice");
				}
				
				isStatic = true;
			} else if (modifier.equals("final")) {
				if (isFinal) {
					throw new CompilationException("Method is defined as final twice");
				}
				
				isFinal = true;
			} else if (! hadReturnType) {
				returnType = modifier;
			}
		}
		
		method.setName(methodName);
		method.setReturnType(returnType);
		method.setVisibility(visibility);
		method.setFinal(isFinal);
		method.setStatic(isStatic);
	}

	private String[] getMethodNameAndModifierTokens(String firstToken,
			BufferedReader reader) throws CompilationException {
		String[] extraTokens = Tokenizer.getTokensBeforeOpenParenthesis(reader);
		String[] tokens = new String[extraTokens.length + 1];
		tokens[0] = firstToken;
		for (int x = 0; x < extraTokens.length; x++) {
			tokens[x + 1] = extraTokens[x];
		}
		return tokens;
	}

	private String readMethodArguments(String token, BufferedReader reader,
			MokaMethod method) throws CompilationException {
		do {
			try {
				char nextChar = Tokenizer.readNextChar(reader);
				if (nextChar == ')') {
					break;
				} else if (nextChar != ','){
					Tokenizer.reset(reader);
				}
				
				MokaMethodVariable argument = new MokaMethodVariable();
				token = Tokenizer.readNextToken(reader);
				argument.setType(token);
				token = Tokenizer.readNextToken(reader);
				argument.setName(token);
				
				method.getArguments().add(argument);
				
				Tokenizer.absorbWhitespace(reader);
				
				nextChar = Tokenizer.readNextChar(reader);
				if (nextChar == '=') {
					token = Tokenizer.readNextToken(reader);
					argument.setDefaultValue(token);
				} else {
					Tokenizer.reset(reader);
				}
				
				Tokenizer.absorbWhitespace(reader);
			} catch (EndOfStreamNotification e) {
				throw new CompilationException("Expected \")\" while parsing method arguments");
			} catch (IOException e) {
				throw new CompilationException(e);
			}
		} while (true);
		return token;
	}

	private String readMethodBody(BufferedReader reader, String methodName)
			throws CompilationException {
		Tokenizer.scanToOpenBrace(reader);
		try {
			Tokenizer.absorbWhitespace(reader, false);
		} catch (EndOfStreamNotification e1) {
			
		}
		
		String content = "";
		int depth = 1;
		do {
			char nextChar;
			try {
				nextChar = Tokenizer.readNextChar(reader);
			} catch (EndOfStreamNotification e) {
				throw new CompilationException("Unbalanced curly braces while reading method \"" + methodName + "\"");
			} catch (IOException e) {
				throw new CompilationException(e);
			}
			
			if (nextChar == '}') {
				depth--;
			} else if (nextChar == '{') {
				depth++;
			}
			
			if (depth > 0) {
				content += nextChar;
			} else {
				break;
			}
		} while (true);
		return content;
	}

	private void checkForConstructorConflict(MokaClass mokaClass, MokaMethod explicitConstructor) throws CompilationException {
		for (MokaMethod existingExplicitConstructor : mokaClass.getExplicitConstructors()) {
			if (existingExplicitConstructor.getArguments().hashCode() == explicitConstructor.getArguments().hashCode()) {
				throw new CompilationException("There are conflicting constructors in " + mokaClass.getName());
			}
		}
	}

	private void defineConstructConstructor(MokaClass mokaClass,
			MokaMethod method) throws CompilationException {
		mokaClass.getConstructors().add(method);
		
		MokaMethod explicitConstructor = new MokaMethod();
		explicitConstructor.setName(mokaClass.getName());
		explicitConstructor.setArguments(method.getArguments());
		explicitConstructor.setVisibility(method.getVisibility());
		explicitConstructor.setContents("\t\tconstruct(" + getMethodCallArguments(method) + ");");
		
		checkForConstructorConflict(mokaClass, explicitConstructor);
		
		mokaClass.getExplicitConstructors().add(explicitConstructor);
		
		method.setVisibility(Visibility.PRIVATE);
	}

	private String getMethodCallArguments(MokaMethod method) {
		String callArguments = "";
		
		boolean firstArgument = true;
		
		for (MokaVariable argument : method.getArguments()) {
			if (firstArgument) {
				firstArgument = false;
			} else {
				callArguments += ", ";
			}
			callArguments += argument.getName();
		}
		
		return callArguments;
	}

	private String indentAndFormatMethodBody(String content) {
		return content.replaceAll("\n$", "").replaceAll("\n\t", "\n\t\t").replaceAll("^\t", "\t\t");
	}

}
