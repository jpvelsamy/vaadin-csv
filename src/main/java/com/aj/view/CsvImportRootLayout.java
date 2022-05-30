package com.aj.view;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.aj.reusuables.ResourceSummary;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

/*
 * TODO 
 * 1. Need to add long running transaction
 * 2. Need to add reset button
 * 3. Need to add a input file table with a process button
 * 4. Need to add summary section at the end 
 */
public class CsvImportRootLayout {

	private final FlexLayout holdingLayout;
	private final FlexLayout resetButtonLayout;
	private final ImportActionSummaryLayout actionSummaryLayout;
	private final ImportResponseLayout responseGridLayout;
	
	/**
	 * We have to add a Table to show the post upload result
	 * S.No, File Name, File size, Initial check, Action
	 */
	public CsvImportRootLayout()
	{
		holdingLayout = ImportCsvFirstStepView.getFlexVerticalLayout(false);
		holdingLayout .setWidth("unset");
		Button resetButton = new Button("Reset All");
		resetButtonLayout = new FlexLayout(resetButton);
		resetButtonLayout.setJustifyContentMode(JustifyContentMode.END);		
		actionSummaryLayout = new ImportActionSummaryLayout();
		FlexLayout importActionAndSummaryLayout = actionSummaryLayout.getLayout();
		holdingLayout.add(resetButtonLayout);
		holdingLayout.add(importActionAndSummaryLayout);
		responseGridLayout = new ImportResponseLayout(new LinkedHashSet<ResourceSummary>());
		FlexLayout gridLayout = responseGridLayout.getLayout();
		holdingLayout.add(gridLayout);
	}
	
	public FlexLayout getRoot()
	{
		return this.holdingLayout;
	}
	
}
