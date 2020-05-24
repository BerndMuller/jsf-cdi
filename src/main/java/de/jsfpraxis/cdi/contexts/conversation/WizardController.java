package de.jsfpraxis.cdi.contexts.conversation;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * Wizard to gather really much data.
 * 
 * @author Bernd Müller
 *
 */
@SuppressWarnings("serial")
@Named
@ConversationScoped
public class WizardController implements Serializable {
	
	private String data1;
	private String data2;
	private String data3;
	
	@Inject
	Logger logger;
	
	@Inject
	Conversation conversation;
	
	@Inject
	FacesContext facesContext;

	public WizardController() {
	}
	
	public String startWizard() {
		logger.info("Wizard is about to start. Conversation is transient: " + conversation.isTransient());
		conversation.begin();
//		if (conversation.isTransient()) {
//			conversation.begin();
//		} else {
//			// some meaningful message to user
//		}
		logger.info("Wizard started. Conversation is transient: " + conversation.isTransient());
		logger.info("timeout: " + conversation.getTimeout());
		return "data-set-1?faces-redirect=true";
	}
	
	public String toDataSet2() {
		logger.info("Data set 1 supplied");
		return "data-set-2?faces-redirect=true";
	}
	
	
	public String toDataSet3() {
		logger.info("Data set 2 supplied");
		return "data-set-3?faces-redirect=true";
	}


	public String backToDataSet1() {
		logger.info("Back to Data set 1");
		return "data-set-1?faces-redirect=true";
	}

	
	public String backToDataSet2() {
		logger.info("Back to Data set 2");
		return "data-set-2?faces-redirect=true";
	}



	public String completeWizard() {
		logger.info("Data set 3 supplied");
		logger.info("Wizard is about to end. Conversation is transient: " + conversation.isTransient());
		logger.info(String.format("Data gathered: %s, %s, %s", data1, data2, data3));
		conversation.end();
		logger.info("Wizard completed. Conversation is transient: " + conversation.isTransient());
		return "completed?faces-redirect=true";		
	}

	
	public String abort() {
		logger.info("Wizard is about to be aborted. Conversation is transient: " + conversation.isTransient());
		conversation.end();
		logger.info("Wizard aborted. Conversation is transient: " + conversation.isTransient());
		return "aborted?faces-redirect=true";		
	}

	
    public void checkConversation(ComponentSystemEvent cse) {
        if (conversation.isTransient()) {
        	logger.warning("Nicht in Konversation für View: " + facesContext.getViewRoot().getViewId()); 
        	facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "wizard.xhtml?faces-redirect=true");
        }
    }
	
	// Getter and Setter
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}

	public String getData3() {
		return data3;
	}
	public void setData3(String data3) {
		this.data3 = data3;
	}

}
