package de.jsfpraxis.cdi.qualifier;

import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.inject.Named;

@Named("biqc")
public class QualifierController {
	
	@Inject
	BeanManager beanManager;
	
	@Inject
	Logger logger;
	
	/**
	 * Get qualifiers for class.
	 * 
	 * @param className qualified class name
	 * @return newline separated list of all qualifiers
	 * @throws ClassNotFoundException if class not found
	 */
	public String getQualifierForClass(String className) throws ClassNotFoundException {
		Class<?> clazz = Class.forName(className);
		String result = "";
		Set<Bean<?>> beans = beanManager.getBeans(clazz);
		if (beans.size() == 1) {
			Set<Annotation> qualifiers = beans.iterator().next().getQualifiers();
			for (Annotation qualifier : qualifiers) {
				result += qualifier + "\n";
			}
		} else {
			throw new IllegalArgumentException("only for simple classes");
		}
		return result;
	}
	
	public void logQualifiersForFactorial() {
		@SuppressWarnings("serial")
		Set<Bean<?>> beans = beanManager.getBeans(Factorial.class, new AnnotationLiteral<Any>() {});
		for (Bean<?> bean : beans) {
			logger.info("logQualifiersForFactorial: " + bean);
		}
	}

	public void logQualifiersForBeanWithIterative() {
		@SuppressWarnings("serial")
		Set<Bean<?>> beans = beanManager.getBeans(BeanWithIterative.class, new AnnotationLiteral<Any>() {});
		for (Bean<?> bean : beans) {
			logger.info("logQualifiersForBeanWithIterative: " + bean);
		}
	}
	
}
