package de.jsfpraxis.cdi.contexts;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class InjectDemo {

	@Inject
	RequestBean requestBean1;
	
	RequestBean requestBean2 = CDI.current().select(RequestBean.class).get();
	
	@Inject
	SessionBean sessionBean1;
	
	SessionBean sessionBean2 = CDI.current().select(SessionBean.class).get();

	public InjectDemo() {
	}

	
	public RequestBean getRequestBean1() {
		return requestBean1;
	}

	public RequestBean getRequestBean2() {
		return requestBean2;
	}

	public SessionBean getSessionBean1() {
		return sessionBean1;
	}

	public SessionBean getSessionBean2() {
		return sessionBean2;
	}
	
}
