package com.factmint.moka.compiler.helper;

public class MathHelper {

	public static int factorialOf(int n) {
		int answer = 1;
		
		for (int x = 2; x <= n; x++) {
			answer *= x;
		}
		
		return answer;
	}

	public static int nChooseR(int n, int r) {
		if (n < r) {
			throw new IllegalArgumentException("Cannot choose " + String.valueOf(r) + " from " + String.valueOf(n));
		}
		
		int nMinusR = n - r;
		
		if (nMinusR > r) {
			r = nMinusR;
			nMinusR = n - r;
		}
		
		int simplifiedNumerator = 1;
		for (int x = n; x > r; x--) {
			simplifiedNumerator *= x;
		}
		
		int simplifiedDenominator = factorialOf(nMinusR);
		
		return simplifiedNumerator / simplifiedDenominator;
	}

}
