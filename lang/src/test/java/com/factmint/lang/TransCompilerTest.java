package com.factmint.lang;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.factmint.lang.exception.CompilationException;

public class TransCompilerTest {

	@Test
	public void transCompileSample1() throws CompilationException, IOException {
		TransCompiler compiler = new TransCompiler();
		
		String filename = this.getClass().getResource("/com/factmint/lang/samples/SampleClass1.lang").getFile();
		String java = compiler.compile(new File(filename));
		
		String expectedJavaFilename = this.getClass().getResource("/com/factmint/lang/expected/SampleClass1.java").getFile();
		byte[] encoded = Files.readAllBytes(Paths.get(expectedJavaFilename));
		
		assertEquals("The compiled file should match the expected Java.", Charset.forName("UTF-8").decode(ByteBuffer.wrap(encoded)).toString(), java);
	}

	@Test
	public void transCompileSample2() throws CompilationException, IOException {
		TransCompiler compiler = new TransCompiler();
		
		String filename = this.getClass().getResource("/com/factmint/lang/samples/SampleClass2.lang").getFile();
		String java = compiler.compile(new File(filename));
		
		String expectedJavaFilename = this.getClass().getResource("/com/factmint/lang/expected/SampleClass2.java").getFile();
		byte[] encoded = Files.readAllBytes(Paths.get(expectedJavaFilename));
		
		assertEquals("The compiled file should match the expected Java.", Charset.forName("UTF-8").decode(ByteBuffer.wrap(encoded)).toString(), java);
	}

	@Test
	public void transCompileSample3() throws CompilationException, IOException {
		TransCompiler compiler = new TransCompiler();
		
		String filename = this.getClass().getResource("/com/factmint/lang/samples/SampleClass3.lang").getFile();
		String java = compiler.compile(new File(filename));
		
		String expectedJavaFilename = this.getClass().getResource("/com/factmint/lang/expected/SampleClass3.java").getFile();
		byte[] encoded = Files.readAllBytes(Paths.get(expectedJavaFilename));
		
		assertEquals("The compiled file should match the expected Java.", Charset.forName("UTF-8").decode(ByteBuffer.wrap(encoded)).toString(), java);
	}
}
