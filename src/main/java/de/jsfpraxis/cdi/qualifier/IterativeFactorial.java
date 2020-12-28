package de.jsfpraxis.cdi.qualifier;

import java.math.BigInteger;

/**
 * Iterative Implementierung der Fakultätsfunktion.
 * 
 * @author Bernd Müller
 *
 */
@Iterative
public class IterativeFactorial implements Factorial {

	@Override
	public BigInteger factorial(int n) {
		BigInteger factorial = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

}
