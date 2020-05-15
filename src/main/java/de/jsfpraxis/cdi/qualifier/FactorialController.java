package de.jsfpraxis.cdi.qualifier;

import java.math.BigInteger;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class FactorialController {

	private int n;
	private BigInteger factorialResult;

	@Inject
	Logger logger;
	
	@Inject
	//@Iterative
	//@Recursive
	@SpecialIterative
	Factorial factorial;

	public FactorialController() {

	}

	public void compute() {
		factorialResult = factorial.factorial(n);
		logger.info("verwende die Implementierung " + factorial.getClass().getCanonicalName());
	}
	
	// Getter and Setter
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}

	public BigInteger getFactorialResult() {
		return factorialResult;
	}
	
}
