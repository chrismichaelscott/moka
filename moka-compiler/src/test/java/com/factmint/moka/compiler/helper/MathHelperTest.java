package com.factmint.moka.compiler.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathHelperTest {

	@Test
	public void testFactorial() {
		assertEquals("0! is 1", 1, MathHelper.factorialOf(0));
		assertEquals("1! is 1", 1, MathHelper.factorialOf(1));
		assertEquals("3! is 6", 6, MathHelper.factorialOf(3));
		assertEquals("10! is 3628800", 3628800, MathHelper.factorialOf(10));
	}

	@Test
	public void testNChooseR() {
		assertEquals("anything choose 0 is 1", 1, MathHelper.nChooseR(10, 0));
		assertEquals("anything choose itself is 1", 1, MathHelper.nChooseR(10, 10));
		assertEquals("6 choose 4 is 15", 15, MathHelper.nChooseR(6, 4));
		assertEquals("150 choose 147 is 551300", 551300, MathHelper.nChooseR(150, 147));
		assertEquals("150 choose 3 is 551300", 551300, MathHelper.nChooseR(150, 3));
	}
}
