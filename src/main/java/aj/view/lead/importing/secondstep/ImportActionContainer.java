package aj.view.lead.importing.secondstep;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class ImportActionContainer {

	private static final String VAR_LUMO_SUCCESS_COLOR_10PCT = "var(--lumo-success-color-10pct)";
	private static final String VAR_LUMO_PRIMARY_COLOR_10PCT = "var(--lumo-primary-color-10pct)";
	
	public static final String IMPORT_MODE_ALL = "all";
	public static final String IMPORT_MODE_CLEAN = "clean";

	private final Div holdingDiv;
	private final Button importButton;
	private final String buttonName;
	private final Anchor importedLink;
	private final Anchor leftOverLink;
	private String importMode = IMPORT_MODE_ALL;// clean is the other option
	private boolean isDisabled;
	

	public ImportActionContainer(String buttonName, String importMode)
	{
		this.buttonName = buttonName;
		this.importMode = importMode;
		this.holdingDiv = new Div();
		
		this.importButton = new Button(this.buttonName);
		this.importedLink =  new Anchor("www.askjuno.com", "Imported");
		this.leftOverLink = new Anchor("www.askjuno.com", "Left over");
		importedLink.getElement().getStyle().set("background-color", VAR_LUMO_SUCCESS_COLOR_10PCT);
		importedLink.getElement().getStyle().set("background-color", VAR_LUMO_PRIMARY_COLOR_10PCT);
		
		this.holdingDiv.add(this.importButton);
		this.holdingDiv.add(importedLink);
		this.holdingDiv.add(leftOverLink);
		
		if(importMode.equals(IMPORT_MODE_ALL)) {
			this.importButton.setIcon(new Icon(VaadinIcon.DOWNLOAD));
			this.importButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		}
		else 
		{
			this.importButton.setIcon(new Icon(VaadinIcon.BELL));
			this.importButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		}
	}
	
	public Div getHoldingDiv()
	{
		return this.holdingDiv;
	}
}
