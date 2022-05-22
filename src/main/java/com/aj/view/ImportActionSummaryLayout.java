package com.aj.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileBuffer;

public class ImportActionSummaryLayout {

	private final FlexLayout importActionAndSummaryLayout;
	private final ImportFileSummaryContainer fileSummaryContainer;
	private final MultiFileBuffer bufferCsv;
	private final Upload uploadCsv;
	
	public ImportActionSummaryLayout()
	{
		importActionAndSummaryLayout = ImportCsvFirstStepView.getFlexHorizontalLayout(true);
		fileSummaryContainer = new ImportFileSummaryContainer();
		bufferCsv = new MultiFileBuffer();
		uploadCsv = new Upload(bufferCsv);
		uploadCsv.setAutoUpload(true);
		uploadCsv.setAcceptedFileTypes("text/csv");
		uploadCsv.setUploadButton(new Button("Select csv"));
		
		
		importActionAndSummaryLayout.add(uploadCsv);
		importActionAndSummaryLayout.add(fileSummaryContainer.getLayout());
		uploadCsv.addSucceededListener(event -> {
			final String fileName = event.getFileName();
			final String length = Long.toString(event.getContentLength());
			boolean checkHealth = CsvUploadEngine.checkHealth(fileName);
			final FileSummary summary = new FileSummary();
			summary.setFileName(fileName);
			summary.setFileSize(length);
			summary.setInitialCheck(checkHealth);
			summary.setStatus(FileSummary.STATUS_NEW);
			fileSummaryContainer.addFileInfo(summary);
			
			//InputStream inputStream = bufferCsv.getInputStream(fileName);
			//we definitely need long running task support
			//https://cookbook.vaadin.com/long-running-task
		});
		
	}
	
	
	public FlexLayout getLayout()
	{
		return this.importActionAndSummaryLayout;
	}
	
}
