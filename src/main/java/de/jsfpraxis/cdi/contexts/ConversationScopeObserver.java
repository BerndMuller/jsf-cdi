package de.jsfpraxis.cdi.contexts;

import java.util.logging.Logger;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.servlet.ServletRequest;

/**
 * Observes if conversation context is initialized or destroyed.
 * 
 * <p>
 * See <a href="https://jakarta.ee/specifications/platform/8/apidocs/javax/enterprise/context/ConversationScoped.html">ConversationScoped</a> for documentation.
 * 
 * @author Bernd Müller
 *
 */
public class ConversationScopeObserver {
	
	@Inject
	Logger logger;
	
	public void conversationCreated(@Observes @Initialized(ConversationScoped.class) ServletRequest request) {
		logger.info("Conversation created.");
	}

	public void conversationRemoved(@Observes @Destroyed(ConversationScoped.class) String cid) {
		logger.info("Conversation with id " + cid + " removed");
	}

}

