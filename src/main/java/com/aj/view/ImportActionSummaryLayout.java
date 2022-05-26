package com.aj.view;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.upload.Upload;

public class ImportActionSummaryLayout {

	private final FlexLayout holdingLayout;
	private final UploadContainer uploadContainer;
	private final ImportFileSummaryContainer fileSummaryContainer;
	private final ProcessedResultsContainer processedResultsContainer;
	
	public ImportActionSummaryLayout()
	{
		this.holdingLayout = ImportCsvFirstStepView.getFlexHorizontalLayout(true);
		this.fileSummaryContainer = new ImportFileSummaryContainer();
		this.uploadContainer = new UploadContainer(this.fileSummaryContainer);
		this.processedResultsContainer = new ProcessedResultsContainer();
		final Upload uploadCsv = this.uploadContainer.getComponent();		
		holdingLayout.add(uploadCsv);
		holdingLayout.add(fileSummaryContainer.getLayout());
		holdingLayout.add(this.processedResultsContainer.getLayout());
		
		
	}
	
	
	public FlexLayout getLayout()
	{
		return this.holdingLayout;
	}
	
}
