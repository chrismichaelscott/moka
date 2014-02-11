package com.factmint.lang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.factmint.lang.exception.CompilationException;
import com.factmint.lang.model.LangClass;
import com.factmint.lang.model.LangMethod;
import com.factmint.lang.model.LangVariable;
import com.factmint.lang.model.LangMember.Visibility;

public class TransCompiler {

	private Charset charSet;
	
	public TransCompiler() {
		this.charSet = Charset.forName("UTF-8");
	}
	
	public TransCompiler(Charset charSet) {
		this.charSet = charSet;
	}

	public String compile(File langFile) throws CompilationException, FileNotFoundException {
		
		LangClass langClass = new LangClass();
		langClass.setName(langFile.getName().replaceAll(".lang$", ""));
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(langFile), charSet));
		
		boolean finished = false;
		do {
			try {
				String token = Tokenizer.readNextToken(reader);
				
				processToken(token, langClass, reader);
			} catch (EndOfStreamNotification e) {
				finished  = true;
			}
			
		} while (! finished);
		
		return new JavaWriter(langClass).toString();
	}
	
	private void processToken(String token, LangClass langClass, BufferedReader reader) throws CompilationException {
		if (token.equals("import")) {
			processImportDeclaration(langClass, reader);

		} else if (token.equals("dependency")) {
			processDependencyDeclaration(langClass, reader);

		} else if (token.equals("field")) {
			processFieldDeclaration(langClass, reader);

		} else {
			processMethodDeclaration(token, langClass, reader);

		}
	}

	private void processImportDeclaration(LangClass langClass,
			BufferedReader reader) throws CompilationException {
		String importClass;
		try {
			importClass = Tokenizer.readNextToken(reader);
		} catch (EndOfStreamNotification e) {
			throw new CompilationException("Reached the end of the file without finding the class to import");
		}
		langClass.getImports().add(importClass );
		
		Tokenizer.checkForLineTermination(reader);
	}

	private void processDependencyDeclaration(LangClass langClass,
			BufferedReader reader) throws CompilationException {
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
		
		langClass.getDependencies().add(LangVariable.create(dependencyType, dependencyName));
		
		Tokenizer.checkForLineTermination(reader);
	}

	private void processFieldDeclaration(LangClass langClass,
			BufferedReader reader) throws CompilationException {
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
		
		langClass.getFields().add(LangVariable.create(fieldType, fieldName));
		
		Tokenizer.checkForLineTermination(reader);
	}

	private void processMethodDeclaration(String token, LangClass langClass,
			BufferedReader reader) throws CompilationException {
		LangMethod method = new LangMethod();
		
		String[] extraTokens = Tokenizer.getTokensBeforeOpenParenthesis(reader);
		String[] tokens = new String[extraTokens.length + 1];
		tokens[0] = token;
		for (int x = 0; x < extraTokens.length; x++) {
			tokens[x + 1] = extraTokens[x];
		}
		
		Visibility visibility = Visibility.PUBLIC;
		String returnType = void.class.getName();
		String methodName = "";
		Boolean isStatic = false;
		Boolean isFinal = false;
		
		int cursor = tokens.length - 1;
		
		methodName = tokens[cursor--];

		if (cursor >= 0) {
			returnType = tokens[cursor--];
		}
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
			}
		}
		
		method.setName(methodName);
		method.setReturnType(returnType);
		method.setVisibility(visibility);
		method.setFinal(isFinal);
		method.setStatic(isStatic);
		
		do {
			try {
				char nextChar = Tokenizer.readNextChar(reader);
				if (nextChar == ')') {
					break;
				} else {
					reader.reset();
				}
				
				LangVariable argument = new LangVariable();
				token = Tokenizer.readNextToken(reader);
				argument.setType(token);
				token = Tokenizer.readNextToken(reader);
				argument.setName(token);
				
				method.getArguments().add(argument);
				
				Tokenizer.absorbWhitespace(reader);
			} catch (EndOfStreamNotification e) {
				throw new CompilationException("Expected \")\" while parsing method arguments");
			} catch (IOException e) {
				throw new CompilationException(e);
			}
		} while (true);
		
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
				throw new CompilationException("Unbalanced curly braces while reading method \"" + method.getName() + "\"");
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
		
		method.setContents(content.replaceAll("\n$", "").replaceAll("\n\t", "\n\t\t").replaceAll("^\t", "\t\t"));
		
		if (method.getName().equals(langClass.getName())) {
			checkForConstructorConflict(langClass, method);
			
			langClass.getExplicitConstructors().add(method);
		} else if (method.getName().equals("construct")) {
			langClass.getConstructors().add(method);
			
			LangMethod explicitConstructor = new LangMethod();
			explicitConstructor.setName(langClass.getName());
			explicitConstructor.setArguments(method.getArguments());
			explicitConstructor.setVisibility(method.getVisibility());
			explicitConstructor.setContents("\t\tconstruct(" + getMethodCallArguments(method) + ");");
			
			checkForConstructorConflict(langClass, explicitConstructor);
			
			langClass.getExplicitConstructors().add(explicitConstructor);
			
			method.setVisibility(Visibility.PRIVATE);
		} else {			
			langClass.getMethods().add(method);
		}
		
	}

	private void checkForConstructorConflict(LangClass langClass, LangMethod explicitConstructor) throws CompilationException {
		for (LangMethod existingExplicitConstructor : langClass.getExplicitConstructors()) {
			if (existingExplicitConstructor.getArguments().hashCode() == explicitConstructor.getArguments().hashCode()) {
				throw new CompilationException("There are conflicting constructors in " + langClass.getName());
			}
		}
	}

	private String getMethodCallArguments(LangMethod method) {
		String callArguments = "";
		
		boolean firstArgument = true;
		
		for (LangVariable argument : method.getArguments()) {
			if (firstArgument) {
				firstArgument = false;
			} else {
				callArguments += ", ";
			}
			callArguments += argument.getName();
		}
		
		return callArguments;
	}

}
