package com.factmint.moka.compiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.factmint.moka.compiler.exception.CompilationException;

public class Tokenizer {

	public static char readNextChar(BufferedReader reader) throws EndOfStreamNotification, IOException {
		reader.mark(1);
		int nextCharValue = reader.read();
		
		if (nextCharValue == -1) {
			throw new EndOfStreamNotification();
		}
		
		return (char) nextCharValue;
	}

	public static String readNextToken(BufferedReader reader) throws CompilationException, EndOfStreamNotification {
		String token = "";
		
		char nextChar = 0;
		
		do {
			
			try {
				reader.mark(1);
				nextChar = readNextChar(reader);
				
				if (Character.isJavaIdentifierPart(nextChar)) {
					token += nextChar;
				} else {
					if (token.isEmpty()) {
						continue;
					} else {
						reader.reset();
						return token;
					}
				}
			} catch (IOException e) {
				throw new CompilationException(e);
			}
			
		} while (true);
	}

	public static void checkForLineTermination(BufferedReader reader) throws CompilationException {		
		do {
			try {
				char nextChar = readNextChar(reader);
				
				if (Character.isWhitespace(nextChar)) {
					continue;
				} else if (nextChar == ';') {
					return;
				}
				
				throw new CompilationException("Expected \";\" but found " + String.valueOf(nextChar));
			} catch (IOException e) {
				throw new CompilationException(e);
			} catch (EndOfStreamNotification e) {
				throw new CompilationException("Reached the end of the file and the line was not terminated!");
			}
			
		} while (true);
	}

	public static String[] getTokensBeforeChar(BufferedReader reader, char target) throws CompilationException {
		List<String> tokens = new ArrayList<String>();
		
		do {
			String token = "";
			try {
				char nextChar;
				do {
					nextChar = readNextChar(reader);
					
					if (Character.isWhitespace(nextChar)) {
						if (token.isEmpty()) {						
							continue;
						} else {
							tokens.add(token);
							break;
						}
					} else if (nextChar == target) {
						if (! token.isEmpty()) {
							tokens.add(token);
						}
						
						String[] results = new String[tokens.size()];
						return tokens.toArray(results );
					}
					
					token += nextChar;
				} while (true);
				
				throw new CompilationException("Expected \"" + target + "\" but found " + String.valueOf(nextChar));
			} catch (IOException e) {
				throw new CompilationException(e);
			} catch (EndOfStreamNotification e) {
				throw new CompilationException("Expected " + target + " but reached the end of the file");
			}
		} while (true);
	}

	public static void scanToChar(BufferedReader reader, char target) throws CompilationException {
		do {
			char nextChar;
			try {
				nextChar = readNextChar(reader);
			} catch (IOException e) {
				throw new CompilationException(e);
			} catch (EndOfStreamNotification e) {
				throw new CompilationException("Expected " + target + " but reached the end of the file");
			}
			
			if (Character.isWhitespace(nextChar)) {
				continue;
			} else if (nextChar == target) {
				return;
			}
		} while (true);
	}

	public static void scanToOpenBrace(BufferedReader reader) throws CompilationException {
		scanToChar(reader, '{');
	}

	public static String[] getTokensBeforeOpenParenthesis(BufferedReader reader) throws CompilationException {
		return getTokensBeforeChar(reader, '(');
	}
	
	public static void absorbWhitespace(BufferedReader reader, boolean continuePastNewline) throws EndOfStreamNotification {
		do {
			try {
				char nextChar = readNextChar(reader);
				
				if (! continuePastNewline && nextChar == '\n') {
					return;
				} else if (Character.isWhitespace(nextChar)) {
					continue;					
				} else {
					reader.reset();
					return;
				}
				
			} catch (Exception e) {
				
			}
			
		} while (true);
	}
	
	public static void absorbWhitespace(BufferedReader reader) throws EndOfStreamNotification {
		absorbWhitespace(reader, true);
	}
	
	public static void reset(BufferedReader reader) throws IOException {
		reader.reset();
	}
}
