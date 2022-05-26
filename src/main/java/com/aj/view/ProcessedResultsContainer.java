package com.aj.view;

import com.aj.reusuables.ImportAuditSummary;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

public class ProcessedResultsContainer {

	private final FlexLayout resultsContainer;
	private final H2 goodBatch = new H2("Good batch");
	private final H2 badBatch = new H2("Bad batch");
	private final H2 uglyBatch = new H2("Ugly batch");	
	private final Span goodBatchValue = new Span("0");
	private final Span badBatchValue = new Span("0");
	private final Span uglyBatchValue = new Span("0");
	private ImportAuditSummary processSummary;
	
	public ProcessedResultsContainer()
	{
		resultsContainer = ImportCsvFirstStepView.getFlexVerticalLayout(true);
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
