package de.jsfpraxis.cdi.interceptors;

import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Simple Controller only to call some methods.
 * 
 * @author Bernd Müller
 *
 */
@Named
@RequestScoped
@Monitored
public class MyController {
	
	private static final int MAX = 5;

	@Inject
	MethodPool pool;
	
	public void action() throws Exception {
		Random rand = new Random();
		for (int i = 0; i < MAX; i++) {
			pool.foo(rand.nextInt(10));
			pool.foo(rand.nextInt(10), rand.nextInt(10));
			pool.foo(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
		}
	}

}
