package de.jsfpraxis.cdi.interceptors;

import java.util.Arrays;
import java.util.logging.Logger;

//import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Monitored
@Interceptor
//@Priority(Interceptor.Priority.APPLICATION + 10)
public class MonitoringInterceptor {

	@Inject
	Logger logger;

	@AroundInvoke
	public Object monitor(InvocationContext context) throws Exception {
		Object[] parameters = context.getParameters();
		context.setParameters(parameters); // NOOP, only to demonstrate
		logger.info("AroundInvoke for " + context.getTarget() + "." + context.getMethod().getName() + "(" + Arrays.deepToString(parameters) + ")");
		Object result = context.proceed();
		logger.info("results in " + result);
		return result;
	}
}
