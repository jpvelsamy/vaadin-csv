package aj.view.lead.importing.firsstep;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.ContentAlignment;

import aj.reusuables.ImportAuditSummary;

import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;

public class ProcessedResultsContainer {

	private final FlexLayout resultsContainer;
	private final H2 goodBatch = new H2("Good batch");
	private final H2 badBatch = new H2("Bad batch");
	private final H2 uglyBatch = new H2("Ugly batch");	
	private final Span goodBatchValue = new Span("None");
	private final Span badBatchValue = new Span("None");
	private final Span uglyBatchValue = new Span("None");
	private ImportAuditSummary processSummary;
	
	public ProcessedResultsContainer()
	{
		resultsContainer = ImportCsvFirstStepView.getFlexVerticalLayout(true);		
		resultsContainer.setAlignContent(ContentAlignment.SPACE_AROUND);
		goodBatchValue.getElement().getThemeList().add("badge success");
		badBatchValue.getElement().getThemeList().add("badge");
		uglyBatchValue.getElement().getThemeList().add("badge error");
		
		createContent();
		
		
	}

	public FlexLayout getLayout()
	{
		return this.resultsContainer;
	}
	
	public void updateContent(ImportAuditSummary totalSummary)
	{
		this.processSummary = processSummary;
		Integer goodLeadCount = totalSummary.getGoodLeadCount();
		Integer badLeadCount = totalSummary.getBadLeadCount();
		Integer uglyLeadCount = totalSummary.getUglyLeadCount();
		this.goodBatchValue.setText(goodLeadCount.toString());
		this.badBatchValue.setText(badLeadCount.toString());
		this.uglyBatchValue.setText(uglyLeadCount.toString());
	}
	
	
	private void createContent() {
		resultsContainer.removeAll();
		resultsContainer.add(goodBatch);
		resultsContainer.add(goodBatchValue);
		resultsContainer.add(badBatch);
		resultsContainer.add(badBatchValue);
		resultsContainer.add(uglyBatch);
		resultsContainer.add(uglyBatchValue);
	}
	
	
	
}
