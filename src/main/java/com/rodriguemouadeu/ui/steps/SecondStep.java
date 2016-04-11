package com.rodriguemouadeu.ui.steps;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.vaadin.teemu.wizards.WizardStep;

import com.rodriguemouadeu.core.model.Gender;
import com.vaadin.shared.ui.ui.NotificationRole;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class SecondStep implements WizardStep {

	private static Logger LOG = Logger.getLogger(SecondStep.class);
	
	private DateField dateOfBirthDateField;
	private ComboBox genderComboBox;
	
	public String getCaption() {
		return "Second Step";
	}

	public Component getContent() {
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setSizeFull();
		
		dateOfBirthDateField = new DateField("Date of birth");
		dateOfBirthDateField.setValue(new Date());
		dateOfBirthDateField.setWidth("50%");
		verticalLayout.addComponent(dateOfBirthDateField);
		verticalLayout.setComponentAlignment(dateOfBirthDateField, Alignment.MIDDLE_LEFT);
		
		genderComboBox = new ComboBox("Gender");
		genderComboBox.setWidth("50%");
		for(Gender gender : Gender.values()){
			genderComboBox.addItem(gender);
		}

		genderComboBox.setRequired(true);
		verticalLayout.addComponent(genderComboBox);
		verticalLayout.setComponentAlignment(genderComboBox, Alignment.MIDDLE_LEFT);
		
		return verticalLayout;
	}

	public boolean onAdvance() {
		Notification.show("Second Step values", toString(), Notification.Type.WARNING_MESSAGE);
		
		return true;
	}
	
	public boolean onBack() {
		return true;
	}

	@Override
	public String toString() {
		return "Date of birth: " + new SimpleDateFormat("yyyy/MM/dd").format(dateOfBirthDateField.getValue())
				+ ", gender: " + genderComboBox.getValue();
	}
}
