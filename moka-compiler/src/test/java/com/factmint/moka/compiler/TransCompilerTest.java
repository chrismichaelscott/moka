package com.factmint.moka.compiler;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.factmint.moka.compiler.TransCompiler;
import com.factmint.moka.compiler.exception.CompilationException;

public class TransCompilerTest {

	@Test
	public void transCompileSample1() throws CompilationException, IOException {
		TransCompiler compiler = new TransCompiler();
		
		String filename = this.getClass().getResource("/com/factmint/moka/compiler/samples/SampleClass1.moka").getFile();
		String java = compiler.compile(new File(filename));
		
		String expectedJavaFilename = this.getClass().getResource("/com/factmint/moka/compiler/expected/SampleClass1.java").getFile();
		byte[] encoded = Files.readAllBytes(Paths.get(expectedJavaFilename));
		
		assertEquals("The compiled file should match the expected Java.", Charset.forName("UTF-8").decode(ByteBuffer.wrap(encoded)).toString(), java);
	}

	@Test
	public void transCompileSample2() throws CompilationException, IOException {
		TransCompiler compiler = new TransCompiler();
		
		String filename = this.getClass().getResource("/com/factmint/moka/compiler/samples/SampleClass2.moka").getFile();
		String java = compiler.compile(new File(filename));
		
		String expectedJavaFilename = this.getClass().getResource("/com/factmint/moka/compiler/expected/SampleClass2.java").getFile();
		byte[] encoded = Files.readAllBytes(Paths.get(expectedJavaFilename));
		
		assertEquals("The compiled file should match the expected Java.", Charset.forName("UTF-8").decode(ByteBuffer.wrap(encoded)).toString(), java);
	}

	@Test
	public void transCompileSample3() throws CompilationException, IOException {
		TransCompiler compiler = new TransCompiler();
		
		String filename = this.getClass().getResource("/com/factmint/moka/compiler/samples/SampleClass3.moka").getFile();
		String java = compiler.compile(new File(filename));
		
		String expectedJavaFilename = this.getClass().getResource("/com/factmint/moka/compiler/expected/SampleClass3.java").getFile();
		byte[] encoded = Files.readAllBytes(Paths.get(expectedJavaFilename));
		
		assertEquals("The compiled file should match the expected Java.", Charset.forName("UTF-8").decode(ByteBuffer.wrap(encoded)).toString(), java);
	}

	@Test
	public void transCompileSample4ExplicitConstructor() throws CompilationException, IOException {
		TransCompiler compiler = new TransCompiler();
		
		String filename = this.getClass().getResource("/com/factmint/moka/compiler/samples/SampleClass4ExplicitConstructor.moka").getFile();
		String java = compiler.compile(new File(filename));
		
		String expectedJavaFilename = this.getClass().getResource("/com/factmint/moka/compiler/expected/SampleClass4ExplicitConstructor.java").getFile();
		byte[] encoded = Files.readAllBytes(Paths.get(expectedJavaFilename));
		
		assertEquals("The compiled file should match the expected Java.", Charset.forName("UTF-8").decode(ByteBuffer.wrap(encoded)).toString(), java);
	}

	@Test(expected = CompilationException.class)
	public void transCompileSample5ConflictingConstructors() throws CompilationException, IOException {
		TransCompiler compiler = new TransCompiler();
		
		String filename = this.getClass().getResource("/com/factmint/moka/compiler/samples/SampleClass5ConflictingConstructors.moka").getFile();
		compiler.compile(new File(filename));
	}

	@Test
	public void transCompileSample66ConstructorVisibility() throws CompilationException, IOException {
		TransCompiler compiler = new TransCompiler();
		
		String filename = this.getClass().getResource("/com/factmint/moka/compiler/samples/SampleClass6ConstructorVisibility.moka").getFile();
		String java = compiler.compile(new File(filename));
		
		String expectedJavaFilename = this.getClass().getResource("/com/factmint/moka/compiler/expected/SampleClass6ConstructorVisibility.java").getFile();
		byte[] encoded = Files.readAllBytes(Paths.get(expectedJavaFilename));
		
		assertEquals("The compiled file should match the expected Java.", Charset.forName("UTF-8").decode(ByteBuffer.wrap(encoded)).toString(), java);
	}
}
