package aj.view.lead.importing.secondstep;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ImportActionContainer {

	private static final String VAR_LUMO_SUCCESS_COLOR_10PCT = "var(--lumo-success-color-10pct)";
	private static final String VAR_LUMO_PRIMARY_COLOR_10PCT = "var(--lumo-primary-color-10pct)";

	public static final String IMPORT_MODE_ALL = "all";
	public static final String IMPORT_MODE_CLEAN = "clean";

	private final VerticalLayout holdingLayout;
	private final Button importButton;
	private final String buttonName;
	private final Anchor importedLink;
	private final Anchor leftOverLink;
	private String importMode = IMPORT_MODE_ALL;// clean is the other option
	private boolean isDisabled;

	public ImportActionContainer(String buttonName, String importMode) {
		this.buttonName = buttonName;
		this.importMode = importMode;
		this.holdingLayout = new VerticalLayout();
		this.holdingLayout.setAlignItems(Alignment.CENTER);

		this.importButton = createImportButton(importMode);

		String href = "www.askjuno.com";
		String importedLinkname = "Imported";
		String color = VAR_LUMO_SUCCESS_COLOR_10PCT;

		this.importedLink = createAnchor(href, importedLinkname, color);

		String leftOverLinkName = "Left over";
		color = VAR_LUMO_PRIMARY_COLOR_10PCT;
		this.leftOverLink = createAnchor(href, leftOverLinkName, color);

		this.holdingLayout.add(this.importButton);
		this.holdingLayout.add(this.importedLink);
		this.holdingLayout.add(this.leftOverLink);

	}

	private Anchor createAnchor(String href, String name, String color) {
		Anchor newAnchor = new Anchor(href, name);
		newAnchor.setWidth(60, Unit.PERCENTAGE);
		newAnchor.getStyle().set("background-color", color);
		newAnchor.getStyle().set("text-align", "center");
		return newAnchor;
	}

	private Button createImportButton(String importMode) {
		Button newButton = new Button(this.buttonName);
		newButton.setWidth(70, Unit.PERCENTAGE);
		if (importMode.equals(IMPORT_MODE_ALL)) {
			newButton.setIcon(new Icon(VaadinIcon.DOWNLOAD));
			newButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		} else {
			newButton.setIcon(new Icon(VaadinIcon.BELL));
			newButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		}
		return newButton;
	}

	public VerticalLayout getLayout() {
		return this.holdingLayout;
	}

}
