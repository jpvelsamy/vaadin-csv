package aj.view.lead.importing.firsstep;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.upload.Upload;

import aj.view.lead.importing.ImportFileSummaryContainer;

public class ImportActionSummaryLayout {

	private final FlexLayout holdingLayout;
	private final UploadContainer uploadContainer;
	private final ImportFileSummaryContainer fileSummaryContainer;
	private final ProcessedResultsContainer processedResultsContainer;
	
	public ImportActionSummaryLayout()
	{
		this.holdingLayout = ImportCsvFirstStepView.getFlexHorizontalLayout(false);
		
		this.fileSummaryContainer = new ImportFileSummaryContainer(false);
		this.uploadContainer = new UploadContainer(this.fileSummaryContainer);
		this.processedResultsContainer = new ProcessedResultsContainer();
		final Upload uploadCsv = this.uploadContainer.getComponent();
		uploadCsv.setWidth(30, Unit.PERCENTAGE);
		holdingLayout.add(uploadCsv);
		FlexLayout fileSummaryHoldingLayout = fileSummaryContainer.getLayout();
		fileSummaryHoldingLayout.setWidth(50, Unit.PERCENTAGE);
		holdingLayout.add(fileSummaryHoldingLayout);
		FlexLayout processingResponseHoldingLayout = this.processedResultsContainer.getLayout();
		processingResponseHoldingLayout.setWidth(30, Unit.PERCENTAGE);				
		holdingLayout.add(processingResponseHoldingLayout);
		
		
	}
	
	
	public FlexLayout getLayout()
	{
		return this.holdingLayout;
	}
	
}
