package de.jsfpraxis.cdi.alternative;

import java.math.BigInteger;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AlternativeController {

	private int n;
	private BigInteger factorialResult;

	@Inject
	Logger logger;
	
	@Inject
	Factorial factorial;

	public AlternativeController() {

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
