package com.aj;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import org.vaadin.miki.superfields.dates.SuperDatePicker;
import org.vaadin.miki.superfields.text.SuperTextField;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;

//https://vaadin.com/forum/thread/17060061/how-to-change-notification-color-text
public class ToasterForAdBuddy {

	private static Random rand = new Random(0xDEADBEEF);
	private static final int DEFAULT_DURATION = 5000;

	private final static String sorryTemplates[] = new String[] { "You silly! ", "Sorry ", "Super sorry ",
			"Hello !!, cant let you go ", "Excuse me boss!! ", "Psst psst,Sorry ", "Buzzzz!! Sorry ",
			"Terribly sorry !! ", "Watch out !!! ", "Oops, we are sorry " };

	private final static String happyTemplates[] = new String[] { "Aweseome Boss! ", "Fantastic, Your grace! ",
			"You made it, Highness! ", "Bring it on baby! " };

	public ToasterForAdBuddy() {
		super();
	}

	public void showSuccess(String message) {
		message = happyTemplates[rand.nextInt(happyTemplates.length)] + message;
		createMsg(message, "blue");
	}

	public void showInfo(String message) {
		createMsg(message, "black");
	}

	public Boolean validateForCorrectness(Integer value, String fieldName) {
		if (value == null) {
			final String errorMessage = sorryTemplates[rand.nextInt(sorryTemplates.length)] + fieldName
					+ ", Please fill it";
			showErrorMsg(errorMessage);
			return false;
		} else
			return true;
	}

	private void showErrorMsg(final String errorMessage) {
		createMsg(errorMessage, "red");
	}

	private void createMsg(final String message, final String color) {
		Span info = new Span(message);
		info.getStyle().set("color", color);
		Notification notification = new Notification(info);
		notification.setPosition(Notification.Position.TOP_CENTER);
		notification.setDuration(5000);
		notification.open();

	}

	public Boolean validateForCorrectness(SuperTextField component, String fieldName) {

		final String value = component.getValue();
		if (value == null || value.trim().length() == 0) {
			final String errorMessage = sorryTemplates[rand.nextInt(sorryTemplates.length)] + fieldName
					+ ", Please fill it";
			showErrorMsg(errorMessage);
			return false;
		} else
			return true;
	}

	public Boolean validateForCorrectness(String fieldName, Checkbox... checkBoxItems) {
		Boolean shouldProceed = false;
		for (int i = 0; i < checkBoxItems.length; i++) {
			if ((shouldProceed = checkBoxItems[i].getValue()) == true)
				return true;
		}
		if (!shouldProceed) {
			final String errorMessage = sorryTemplates[rand.nextInt(sorryTemplates.length)] + " ," + fieldName
					+ ", You need to choose at least one ";
			showErrorMsg(errorMessage);
			return false;
		}
		return shouldProceed;

	}

	public Boolean validateForCorrectness(SuperDatePicker component, String fieldName) {
		final LocalDate value = component.getValue();
		if (value == null) {
			final String errorMessage = sorryTemplates[rand.nextInt(sorryTemplates.length)] + " ," + fieldName
					+ ", Please select a valid date";
			showErrorMsg(errorMessage);
			return false;
		} else
			return true;
	}

	public void showError(String message) {
		final String errorMessage = sorryTemplates[rand.nextInt(sorryTemplates.length)] + " " + message;
		showErrorMsg(errorMessage);
	}

	public void showWarn(String message) {
		final String warnMessage = sorryTemplates[rand.nextInt(sorryTemplates.length)] + " " + message;
		createMsg(warnMessage, "orange");
	}

	public Boolean validateForCorrectness(NumberField component, String fieldName) {
		final Double value = component.getValue();
		if (value == null) {
			final String errorMessage = sorryTemplates[rand.nextInt(sorryTemplates.length)] + fieldName
					+ ", Please fill it";
			showErrorMsg(errorMessage);
			return false;
		} else
			return true;
	}

	public Boolean validateForCorrectness(TimePicker component, String fieldName) {
		final LocalTime value = component.getValue();
		if (value == null) {
			final String errorMessage = sorryTemplates[rand.nextInt(sorryTemplates.length)] + fieldName
					+ ", Please fill it";
			showErrorMsg(errorMessage);
			return false;
		} else
			return true;
	}

	public Boolean validateForCorrectness(TextField component, String fieldName) {
		final String value = component.getValue();
		if (value == null) {
			final String errorMessage = sorryTemplates[rand.nextInt(sorryTemplates.length)] + fieldName
					+ ", Please fill it";
			showErrorMsg(errorMessage);
			return false;
		} else
			return true;
	}

	public Boolean validateForCorrectness(ComboBox<String> component, String fieldName) {
		final String value = component.getValue();
		if (value == null) {
			final String errorMessage = sorryTemplates[rand.nextInt(sorryTemplates.length)] + fieldName
					+ ", Please fill it";
			showErrorMsg(errorMessage);
			return false;
		} else
			return true;

	}

}
