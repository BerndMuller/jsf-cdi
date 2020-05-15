package de.jsfpraxis.cdi.qualifier;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FactorialTest {
	
	private static IterativeFactorial ifac;
	private static RecursiveFactorial rfac;
	private static final String FACTORIAL_100 = "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000";

	@BeforeClass
	public static void setUp() {
		ifac = new IterativeFactorial();
		rfac = new RecursiveFactorial();
	}

	@Test
	public void factorial0() {
		Assert.assertEquals(BigInteger.ONE, ifac.factorial(0));
		Assert.assertEquals(BigInteger.ONE, rfac.factorial(0));
	}

	@Test
	public void factorial1() {
		Assert.assertEquals(BigInteger.ONE, ifac.factorial(1));
		Assert.assertEquals(BigInteger.ONE, rfac.factorial(1));
	}

	@Test
	public void factorial10() {
		Assert.assertEquals(BigInteger.valueOf(3628800), ifac.factorial(10));
		Assert.assertEquals(BigInteger.valueOf(3628800), rfac.factorial(10));
	}

	@Test
	public void factorial100() {
		Assert.assertEquals(new BigInteger(FACTORIAL_100), ifac.factorial(100));
		Assert.assertEquals(new BigInteger(FACTORIAL_100), rfac.factorial(100));
	}

}
