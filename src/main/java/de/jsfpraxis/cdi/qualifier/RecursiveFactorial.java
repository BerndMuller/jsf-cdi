package de.jsfpraxis.cdi.qualifier;

import java.math.BigInteger;

@Recursive
public class RecursiveFactorial implements Factorial {

	@Override
	public BigInteger factorial(int n) {
		if (n <= 0) {
			return BigInteger.ONE;
		} else {
			return BigInteger.valueOf(n).multiply(factorial(n - 1));
		}
	}

}
