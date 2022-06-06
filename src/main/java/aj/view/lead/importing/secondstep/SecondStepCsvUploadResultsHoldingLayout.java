package aj.view.lead.importing.secondstep;

import com.vaadin.flow.component.orderedlayout.FlexLayout;

import aj.view.lead.importing.firsstep.ImportCsvFirstStepView;

public class SecondStepCsvUploadResultsHoldingLayout {

	private final FlexLayout holdingLayout;	
	private final SecondStepImportSummaryRowLayout rowLayout;

	public SecondStepCsvUploadResultsHoldingLayout() {
		this.holdingLayout = ImportCsvFirstStepView.getFlexVerticalLayout(false);
		this.rowLayout = new SecondStepImportSummaryRowLayout();
		FlexLayout reportCountFirstRowContainer = this.rowLayout.getLayout();
		//this.reportCountSecondRowContainer = new SecondStepImportActionLayout().getLayout();
		this.holdingLayout.add(reportCountFirstRowContainer);
		//this.holdingLayout.add(this.reportCountSecondRowContainer);
	}
	
	public FlexLayout getLayout()
	{
		return this.holdingLayout;
	}

}
