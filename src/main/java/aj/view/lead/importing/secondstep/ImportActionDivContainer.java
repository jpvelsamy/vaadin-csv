package aj.view.lead.importing.secondstep;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

/**
 * I have tried to experiment with this class on using divs
 * @author jpvel
 *
 */
public class ImportActionDivContainer {

	private static final String VAR_LUMO_SUCCESS_COLOR_10PCT = "var(--lumo-success-color-10pct)";
	private static final String VAR_LUMO_PRIMARY_COLOR_10PCT = "var(--lumo-primary-color-10pct)";

	public static final String IMPORT_MODE_ALL = "all";
	public static final String IMPORT_MODE_CLEAN = "clean";

	private final Div ext3Div;
	private final Div buttonDiv;
	private final Div importedLinkDiv;
	private final Div leftoverLinkDiv;
	private final Button importButton;
	private final String buttonName;
	private final Anchor importedLink;
	private final Anchor leftOverLink;
	private String importMode = IMPORT_MODE_ALL;// clean is the other option
	private boolean isDisabled;

	public ImportActionDivContainer(String buttonName, String importMode) {
		this.buttonName = buttonName;
		this.importMode = importMode;
		this.ext3Div = new Div();
		this.ext3Div.getStyle().set("display", "table");
		this.ext3Div.getStyle().set("border-spacing", "5pt");

		String topDivLocation = "top";
		String centerDivLocation = "middle";
		String bottomDivLocation = "bottom";

		this.buttonDiv = createDiv(topDivLocation);
		this.buttonDiv.setWidthFull();
		this.importButton = new Button(this.buttonName);
		this.importButton.setWidthFull();
		this.buttonDiv.add(this.importButton);
		this.ext3Div.add(this.buttonDiv);

		this.importedLinkDiv = createDiv(centerDivLocation);
		this.importedLinkDiv.setWidthFull();
		this.importedLink = new Anchor("www.askjuno.com", "Imported");
		this.importedLink.setWidthFull();
		this.importedLink.getElement().getStyle().set("background-color", VAR_LUMO_SUCCESS_COLOR_10PCT);
		this.importedLinkDiv.add(importedLink);
		this.ext3Div.add(this.importedLinkDiv);

		this.leftoverLinkDiv = createDiv(bottomDivLocation);
		this.leftoverLinkDiv.setWidthFull();
		this.leftOverLink = new Anchor("www.askjuno.com", "Left over");
		this.leftOverLink.setWidthFull();
		this.leftOverLink.getElement().getStyle().set("background-color", VAR_LUMO_PRIMARY_COLOR_10PCT);
		this.leftoverLinkDiv.add(leftOverLink);
		this.ext3Div.add(this.leftoverLinkDiv);

		if (importMode.equals(IMPORT_MODE_ALL)) {
			this.importButton.setIcon(new Icon(VaadinIcon.DOWNLOAD));
			this.importButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		} else {
			this.importButton.setIcon(new Icon(VaadinIcon.BELL));
			this.importButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		}

	}

	private Div createDiv(String location) {
		Div newDiv = new Div();		
		newDiv.getElement().getStyle().set("display", "table-cell");
		newDiv.getElement().getStyle().set("text-align", "center");
		newDiv.getElement().getStyle().set("align-items", "center");
		newDiv.getStyle().set("width", "150px");
		newDiv.getStyle().set("height", "150px");
		newDiv.getElement().getStyle().set("vertical-align", location);
		return newDiv;
	}

	public Div getHoldingDiv() {
		return this.ext3Div;
	}
}
