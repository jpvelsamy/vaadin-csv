package aj.view.lead.importing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.vaadin.componentfactory.NoScrollGrid;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout.ContentAlignment;
import com.vaadin.flow.data.provider.InMemoryDataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;

import aj.DalUtil;
import aj.DateUtil;
import aj.reusuables.ImportAuditLineItem;

import aj.view.lead.importing.firsstep.ImportCsvFirstStepView;

public class ImportFileSummaryContainer {

	private final FlexLayout resultContainer;
	private final NoScrollGrid<ImportAuditLineItem> summaryTable = new NoScrollGrid<ImportAuditLineItem>();
	private final AtomicInteger counter = new AtomicInteger(1);
	private final Map<String, ImportAuditLineItem> fileMap = new LinkedHashMap<String, ImportAuditLineItem>();
	private final InMemoryDataProvider<ImportAuditLineItem> dataProvider = new ListDataProvider<>(fileMap.values());
	private final Boolean isReportingOnly;

	/**
	 * S.No, File Name, File size, Initial check, Action
	 */
	public ImportFileSummaryContainer(boolean isReportingOnly) {
		this.isReportingOnly = isReportingOnly;
		this.resultContainer = ImportCsvFirstStepView.getFlexVerticalLayout(false);
		this.resultContainer.setAlignContent(ContentAlignment.STRETCH);
		this.resultContainer.setJustifyContentMode(JustifyContentMode.EVENLY);
		this.resultContainer.setAlignItems(Alignment.START);

		Column<ImportAuditLineItem> fileName = summaryTable.addColumn(ImportAuditLineItem::getFileName)
				.setHeader("File name").setAutoWidth(true);
		Column<ImportAuditLineItem> fileSize = summaryTable.addColumn(ImportAuditLineItem::getFileSize)
				.setHeader("File size").setAutoWidth(true);
		Column<ImportAuditLineItem> healthStatus = summaryTable.addColumn(ImportAuditLineItem::getInitialCheck)
				.setHeader("Health status").setAutoWidth(true);
		Column<ImportAuditLineItem> rowCount = summaryTable.addColumn(ImportAuditLineItem::getRowCount)
				.setHeader("Rows").setAutoWidth(true);
		Column<ImportAuditLineItem> colCount = summaryTable.addColumn(ImportAuditLineItem::getRowCount)
				.setHeader("Columns").setAutoWidth(true);
		if (!this.isReportingOnly) {
			Column<ImportAuditLineItem> actionColumn = summaryTable
					.addComponentColumn(fileSummary -> createActionLayout(fileSummary)).setAutoWidth(true);
		}

		this.summaryTable.setDataProvider(dataProvider);

		this.resultContainer.add(this.summaryTable);
		populateSample();
		this.dataProvider.refreshAll();

	}

	private HorizontalLayout createActionLayout(ImportAuditLineItem fileSummary) {
		final Button processButton = new Button("Process");
		final Button deleteButton = new Button("Delete");
		final HorizontalLayout actionLayout = new HorizontalLayout(processButton, deleteButton);
		processButton.addClickListener(event -> {
			// Do the processing and change the status
			processButton.setEnabled(false);
			processButton.setText("PROCESSED");
		});
		deleteButton.addClickListener(event -> {
			fileMap.remove(fileSummary.getFileName());
			this.dataProvider.refreshAll();
		});
		return actionLayout;
	}

	public void addFileInfo(ImportAuditLineItem fileSummary) {
		this.fileMap.put(fileSummary.getFileName(), fileSummary);
		this.dataProvider.refreshAll();
	}

	public void reset() {

	}

	public FlexLayout getLayout() {

		// this.summaryTable.setItems(this.fileMap.values());
		return this.resultContainer;
	}

	private void populateSample() {

		String id1 = DalUtil.createLongId();
		String objectType = "lead.csv";
		ImportAuditLineItem i1 = new ImportAuditLineItem(id1, objectType);
		i1.setFileName("lead from cbe.csv");
		i1.setFileSize("10kb");
		i1.setImportedDate(DateUtil.getNowDate());
		i1.setRowCount(100);

		String id2 = DalUtil.createLongId();
		ImportAuditLineItem i2 = new ImportAuditLineItem(id2, objectType);
		i2.setFileName("lead from cbe.csv");
		i2.setFileSize("10kb");
		i2.setRowCount(200);
		i2.setImportedDate(DateUtil.getNowDate());
		this.fileMap.put(id1, i1);
		this.fileMap.put(id2, i2);
	}

}
