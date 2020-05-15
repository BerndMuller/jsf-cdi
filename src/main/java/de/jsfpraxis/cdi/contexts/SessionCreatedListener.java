package de.jsfpraxis.cdi.contexts;

import java.util.logging.Logger;

import javax.enterprise.context.Initialized;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.servlet.http.HttpSession;

public class SessionCreatedListener {
	
	public void sessionCreated(@Observes @Initialized(SessionScoped.class) HttpSession session) {
		Logger.getLogger(SessionCreatedListener.class.getCanonicalName()).info("Session created: " + session.getId());
	}
	
}

