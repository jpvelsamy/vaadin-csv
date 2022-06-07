package aj.view.lead.importing.secondstep;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout.ContentAlignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

import aj.view.lead.importing.firsstep.ImportCsvFirstStepView;

public class SecondStepCsvUploadResultsHoldingLayout {

	private final FlexLayout holdingLayout;
	private final SecondStepImportSummaryRowLayout summaryDetailsLayout;
	private final SecondStepImportActionLayout actionLayout;
	private final SecondStepFileSummaryGridContainer fileSummaryContainer;
	private final ImportedLeadGridContainer importedLeadContainer;
	private final FlexLayout goBackLayout;
	private final Button goBack;
	private final FlexLayout saveLayout;
	private final Button finishImport;

	public SecondStepCsvUploadResultsHoldingLayout() {
		this.holdingLayout = ImportCsvFirstStepView.getFlexVerticalLayout(false);
		this.holdingLayout.setAlignContent(ContentAlignment.STRETCH);
		this.holdingLayout.setJustifyContentMode(JustifyContentMode.EVENLY);
		//this.holdingLayout.setAlignItems(Alignment.START);
		this.summaryDetailsLayout = new SecondStepImportSummaryRowLayout();
		FlexLayout reportCountFirstRowContainer = this.summaryDetailsLayout.getLayout();

		this.goBack = new Button("Start over");
		this.goBackLayout = new FlexLayout(goBack);
		goBackLayout.setJustifyContentMode(JustifyContentMode.START);
		holdingLayout.add(goBackLayout);

		this.holdingLayout.add(reportCountFirstRowContainer);

		this.actionLayout = new SecondStepImportActionLayout();
		this.holdingLayout.add(this.actionLayout.getLayout());

		this.fileSummaryContainer = new SecondStepFileSummaryGridContainer();
		FlexLayout fileSummaryLayout = this.fileSummaryContainer.getLayout();		
		this.holdingLayout.add(fileSummaryLayout);
		
		this.importedLeadContainer = new ImportedLeadGridContainer();
		FlexLayout leadGridLayout = this.importedLeadContainer.getLayout();
		this.holdingLayout.add(leadGridLayout);
		
		this.finishImport = new Button("Finish import");
		this.saveLayout = new FlexLayout();
		this.saveLayout.setJustifyContentMode(JustifyContentMode.END);
		this.saveLayout.add(this.finishImport);
		this.holdingLayout.add(saveLayout);
		this.holdingLayout.setAlignSelf(Alignment.END, this.saveLayout);

	}

	public FlexLayout getLayout() {
		return this.holdingLayout;
	}

}
