package com.aj.view.lead.importing.secondstep;

import com.aj.view.lead.importing.firsstep.ImportCsvFirstStepView;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

public class SecondStepCsvUploadResultsTopLayout {

	private final FlexLayout holdingLayout;
	private final FlexLayout reportCountSecondRowContainer;
	private final SecondStepImportSummaryRowLayout rowLayout;

	public SecondStepCsvUploadResultsTopLayout() {
		this.holdingLayout = ImportCsvFirstStepView.getFlexVerticalLayout(false);
		this.rowLayout = new SecondStepImportSummaryRowLayout();
		FlexLayout reportCountFirstRowContainer = this.rowLayout.getLayout();
		this.reportCountSecondRowContainer = ImportCsvFirstStepView.getFlexHorizontalLayout(false);
		this.holdingLayout.add(reportCountFirstRowContainer);
		this.holdingLayout.add(this.reportCountSecondRowContainer);
	}
	
	public FlexLayout getLayout()
	{
		return this.holdingLayout;
	}

}
