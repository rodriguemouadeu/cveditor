package com.rodriguemouadeu.ui.steps;

import org.vaadin.teemu.wizards.WizardStep;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class FirstStep implements WizardStep {

	private TextField usernameTextField;
	private PasswordField passwordField;
	private PasswordField passwordConfirmationField;
	
	public String getCaption() {
		return "First Step";
	}

	public Component getContent() {
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setSizeFull();
		
		Label label = new Label("Enter your name");
		verticalLayout.addComponent(label);
		verticalLayout.setComponentAlignment(label, Alignment.MIDDLE_LEFT);
		
		usernameTextField = new TextField("Select a username");
		usernameTextField.setWidth("50%");
		usernameTextField.setRequired(true);
		verticalLayout.addComponent(usernameTextField);
		verticalLayout.setComponentAlignment(usernameTextField, Alignment.MIDDLE_LEFT);
		
		passwordField = new PasswordField("Select password");
		passwordField.setWidth("50%");
		passwordField.setRequired(true);
		verticalLayout.addComponent(passwordField);
		verticalLayout.setComponentAlignment(passwordField, Alignment.MIDDLE_LEFT);
		
		passwordConfirmationField = new PasswordField("Confirm password");
		passwordConfirmationField.setWidth("50%");
		passwordConfirmationField.setRequired(true);
		verticalLayout.addComponent(passwordConfirmationField);
		verticalLayout.setComponentAlignment(passwordConfirmationField, Alignment.MIDDLE_LEFT);
		
		return verticalLayout;
	}

	public boolean onAdvance() {
		Notification.show("First Step values", toString(), Notification.Type.WARNING_MESSAGE);
		
		return true;
		
	}

	public boolean isValid(){
		return usernameTextField.isValid() && passwordConfirmationField.isValid() && passwordField.isValid()
				&& (passwordField.getValue().equals(passwordConfirmationField.getValue()));
	}
	
	public boolean onBack() {
		return false;
	}
	
	public String toString(){
		return "Username:" + usernameTextField.getValue() + ", password: " + passwordField.getValue();
	}

}
