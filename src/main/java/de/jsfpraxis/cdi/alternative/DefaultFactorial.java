package de.jsfpraxis.cdi.alternative;

import java.math.BigInteger;

public class DefaultFactorial implements Factorial {

	@Override
	public BigInteger factorial(int n) {
		BigInteger factorial = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

}
