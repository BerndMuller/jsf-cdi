package de.jsfpraxis.cdi.interceptors;

import java.util.Arrays;

public class MethodPool {

	@Monitored
	public int foo(int ... args) {
		return Arrays.stream(args).sum();
	}

}
