package com.rodriguemouadeu;

import javax.servlet.annotation.WebServlet;

import org.apache.log4j.Logger;
import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.event.WizardCancelledEvent;
import org.vaadin.teemu.wizards.event.WizardCompletedEvent;
import org.vaadin.teemu.wizards.event.WizardProgressListener;
import org.vaadin.teemu.wizards.event.WizardStepActivationEvent;
import org.vaadin.teemu.wizards.event.WizardStepSetChangedEvent;

import com.rodriguemouadeu.ui.steps.FirstStep;
import com.rodriguemouadeu.ui.steps.SecondStep;
import com.rodriguemouadeu.ui.steps.ThirdStep;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("com.rodriguemouadeu.MyAppWidgetset")
public class MyUI extends UI implements WizardProgressListener {

	private static final long serialVersionUID = -771667952454309382L;
	
	private static Logger LOG = Logger.getLogger(MyUI.class);
	
	private VerticalLayout layout;
	private Wizard wizard; 
	private FirstStep firstStep;
	private SecondStep secondStep;
	private ThirdStep thirdStep;
	
	@Override
    protected void init(VaadinRequest vaadinRequest) {
       layout = new VerticalLayout();
        
        wizard = new Wizard();
        wizard.addStep(firstStep = new FirstStep());
        wizard.addStep(secondStep = new SecondStep());
        wizard.addStep(thirdStep = new ThirdStep());
        layout.addComponent(wizard);
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 2952315948994206293L;

			@Override
			public void buttonClick(ClickEvent event) {
	            layout.addComponent(new Label("Thanks " + name.getValue() 
	                    + ", it works!"));
			}
        });
        
        layout.addComponents(name, button);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

		private static final long serialVersionUID = -6522589653300152636L;
    }

	@Override
	public void activeStepChanged(WizardStepActivationEvent event) {
		Notification.show("Step changed: " + event.getActivatedStep().getCaption(), Notification.Type.HUMANIZED_MESSAGE);
	}

	@Override
	public void stepSetChanged(WizardStepSetChangedEvent event) {
		Notification.show("Step changed", Notification.Type.HUMANIZED_MESSAGE);
	}

	@Override
	public void wizardCancelled(WizardCancelledEvent event) {
		wizard.getFinishButton().setEnabled(true);
	}

	@Override
	public void wizardCompleted(WizardCompletedEvent event) {
		StringBuilder message = new StringBuilder();
		message.append(firstStep.toString());
		message.append(secondStep.toString());
		message.append(thirdStep.toString());
		
		Notification.show("Completed", message.toString(), Notification.Type.TRAY_NOTIFICATION);
	}
}