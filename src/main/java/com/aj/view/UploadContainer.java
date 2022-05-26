package com.aj.view;

import com.aj.csv.CsvUploadEngine;
import com.aj.reusuables.ResourceSummary;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileBuffer;

public class UploadContainer {

	private final MultiFileBuffer bufferCsv;
	private final Upload uploadCsv;
	private final ImportFileSummaryContainer fileSummaryContainer;

	public UploadContainer(ImportFileSummaryContainer fileSummaryContainer) {
		this.fileSummaryContainer = fileSummaryContainer;
		bufferCsv = new MultiFileBuffer();
		uploadCsv = new Upload(bufferCsv);
		uploadCsv.setAutoUpload(true);
		uploadCsv.setAcceptedFileTypes("text/csv");
		uploadCsv.setUploadButton(new Button("Select csv"));

		uploadCsv.addSucceededListener(event -> {
			final String fileName = event.getFileName();
			final String length = Long.toString(event.getContentLength());
			boolean checkHealth = CsvUploadEngine.checkHealth(fileName);
			final ResourceSummary summary = new ResourceSummary();
			summary.setFileName(fileName);
			summary.setFileSize(length);
			summary.setInitialCheck(checkHealth);
			summary.setStatus(ResourceSummary.STATUS_NEW);
			fileSummaryContainer.addFileInfo(summary);

			// InputStream inputStream = bufferCsv.getInputStream(fileName);
			// we definitely need long running task support
			// https://cookbook.vaadin.com/long-running-task
		});
	}

	public Upload getComponent() {
		return this.uploadCsv;
	}

}
