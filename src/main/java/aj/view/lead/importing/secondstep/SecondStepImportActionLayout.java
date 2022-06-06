package aj.view.lead.importing.secondstep;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class SecondStepImportActionLayout {
	private static final String VAR_LUMO_SUCCESS_COLOR_10PCT = "var(--lumo-success-color-10pct)";
	private static final String VAR_LUMO_PRIMARY_COLOR_10PCT = "var(--lumo-primary-color-10pct)";
	private static final String VAR_LUMO_ERROR_COLOR_10PCT = "var(--lumo-error-color-10pct)";
	private final VerticalLayout holdingLayout;
	

	public SecondStepImportActionLayout() {
		this.holdingLayout = new VerticalLayout();
		this.holdingLayout.setAlignItems(Alignment.CENTER);
		//this.holdingLayout.setJustifyContentMode(JustifyContentMode.EVENLY);
		//this.holdingLayout.setAlignContent(ContentAlignment.END);
		
		Div header = new Div();
		H3 downloadLinks = new H3("Download links");
		header.add(downloadLinks);
		this.holdingLayout.add(header);
		this.holdingLayout.setJustifyContentMode(JustifyContentMode.EVENLY);

	
		
		Anchor goodBatch = new Anchor("www.askjuno.com", "Good batch");
		Anchor badBatch = new Anchor("www.askjuno.com", "Bad batch");
		Anchor uglyBatch = new Anchor("www.askjuno.com", "Ugly batch");
		goodBatch.getElement().getStyle().set("background-color", VAR_LUMO_SUCCESS_COLOR_10PCT);
		badBatch.getElement().getStyle().set("background-color", VAR_LUMO_PRIMARY_COLOR_10PCT);
		uglyBatch.getElement().getStyle().set("background-color", VAR_LUMO_ERROR_COLOR_10PCT);
		
		goodBatch.getElement().getStyle().set("border-radius", "10%");
		badBatch.getElement().getStyle().set("border-radius", "10%");
		uglyBatch.getElement().getStyle().set("border-radius", "10%");
		
		this.holdingLayout.add(header);
		this.holdingLayout.add(goodBatch);
		this.holdingLayout.add(badBatch);
		this.holdingLayout.add(uglyBatch);

	
	}

	public VerticalLayout getLayout() {
		return this.holdingLayout;
	}

}
