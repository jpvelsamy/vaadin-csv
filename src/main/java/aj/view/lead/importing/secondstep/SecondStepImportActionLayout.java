package aj.view.lead.importing.secondstep;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.ContentAlignment;

import aj.view.lead.importing.firsstep.ImportCsvFirstStepView;

public class SecondStepImportActionLayout {
	private static final String VAR_LUMO_SUCCESS_COLOR_10PCT = "var(--lumo-success-color-10pct)";
	private static final String VAR_LUMO_PRIMARY_COLOR_10PCT = "var(--lumo-primary-color-10pct)";
	private static final String VAR_LUMO_ERROR_COLOR_10PCT = "var(--lumo-error-color-10pct)";
	private final FlexLayout holdingLayout;
	private final FlexLayout downloadLinkLayout;

	public SecondStepImportActionLayout() {
		this.holdingLayout = ImportCsvFirstStepView.getFlexVerticalLayout(true);
		this.downloadLinkLayout = ImportCsvFirstStepView.getFlexHorizontalLayout(true);
		this.holdingLayout.setJustifyContentMode(JustifyContentMode.EVENLY);
		this.holdingLayout.setAlignContent(ContentAlignment.END);
		Div header = new Div();
		H3 downloadLinks = new H3("Download links");
		header.add(downloadLinks);
		this.holdingLayout.add(header);
		this.holdingLayout.setAlignSelf(Alignment.START, header);

		this.downloadLinkLayout.setJustifyContentMode(JustifyContentMode.EVENLY);
		this.downloadLinkLayout.setAlignItems(Alignment.CENTER);
		Anchor goodBatch = new Anchor("www.askjuno.com", "Good batch");
		Anchor badBatch = new Anchor("www.askjuno.com", "Bad batch");
		Anchor uglyBatch = new Anchor("www.askjuno.com", "Ugly batch");
		goodBatch.getElement().getStyle().set("text-color", VAR_LUMO_SUCCESS_COLOR_10PCT);
		badBatch.getElement().getStyle().set("text-color", VAR_LUMO_PRIMARY_COLOR_10PCT);
		uglyBatch.getElement().getStyle().set("text-color", VAR_LUMO_ERROR_COLOR_10PCT);
		this.downloadLinkLayout.add(goodBatch);
		this.downloadLinkLayout.add(badBatch);
		this.downloadLinkLayout.add(uglyBatch);

		this.holdingLayout.add(this.downloadLinkLayout);
	}

	public FlexLayout getLayout() {
		return this.holdingLayout;
	}

}
