package aj.view.lead.importing.firsstep;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileBuffer;

import aj.DalUtil;
import aj.csv.CsvUploadEngine;
import aj.reusuables.ImportAuditLineItem;
import aj.view.lead.importing.ImportFileSummaryContainer;

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
			String longId = DalUtil.createLongId();
			String businessObjectType = "lead.csv";
			final ImportAuditLineItem summary = new ImportAuditLineItem(longId, businessObjectType);
			summary.setFileName(fileName);
			summary.setFileSize(length);
			summary.setInitialCheck(checkHealth);
			summary.setStatus(ImportAuditLineItem.STATUS_NEW);
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
