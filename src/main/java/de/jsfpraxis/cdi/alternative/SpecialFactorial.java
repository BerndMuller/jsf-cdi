package de.jsfpraxis.cdi.alternative;

import java.math.BigInteger;

import javax.enterprise.inject.Alternative;

//@Priority(100)
@Alternative
public class SpecialFactorial implements Factorial {

	@Override
	public BigInteger factorial(int n) {
		if (n <= 0) {
			return BigInteger.ONE;
		} else {
			return BigInteger.valueOf(n).multiply(factorial(n - 1));
		}
	}

}
