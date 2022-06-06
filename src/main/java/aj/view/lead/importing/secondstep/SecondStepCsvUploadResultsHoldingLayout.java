package aj.view.lead.importing.secondstep;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

import aj.view.lead.importing.firsstep.ImportCsvFirstStepView;

public class SecondStepCsvUploadResultsHoldingLayout {

	private final FlexLayout holdingLayout;
	private final SecondStepImportSummaryRowLayout summaryDetailsLayout;
	private final SecondStepImportActionLayout actionLayout;
	private final FlexLayout goBackLayout;
	private final Button goBack;

	public SecondStepCsvUploadResultsHoldingLayout() {
		this.holdingLayout = ImportCsvFirstStepView.getFlexVerticalLayout(false);
		this.summaryDetailsLayout = new SecondStepImportSummaryRowLayout();
		FlexLayout reportCountFirstRowContainer = this.summaryDetailsLayout.getLayout();

		this.goBack = new Button("Start over");
		this.goBackLayout = new FlexLayout(goBack);
		goBackLayout.setJustifyContentMode(JustifyContentMode.START);
		holdingLayout.add(goBackLayout);

		this.holdingLayout.add(reportCountFirstRowContainer);

		this.actionLayout = new SecondStepImportActionLayout();
		this.holdingLayout.add(this.actionLayout.getLayout());

	}

	public FlexLayout getLayout() {
		return this.holdingLayout;
	}

}
