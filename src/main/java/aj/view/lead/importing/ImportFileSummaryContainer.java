package aj.view.lead.importing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.vaadin.componentfactory.NoScrollGrid;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.provider.InMemoryDataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;

import aj.reusuables.ImportAuditLineItem;


import aj.view.lead.importing.firsstep.ImportCsvFirstStepView;

public class ImportFileSummaryContainer {

	private final FlexLayout resultContainer;
	private final NoScrollGrid<ImportAuditLineItem> summaryTable = new NoScrollGrid<ImportAuditLineItem>();
	private final AtomicInteger counter = new AtomicInteger(1);
	private final Map<String, ImportAuditLineItem> fileMap = new LinkedHashMap<String, ImportAuditLineItem>();
	private final InMemoryDataProvider<ImportAuditLineItem> dataProvider = new ListDataProvider<>(fileMap.values());
	
	/**
	 * S.No, File Name, File size, Initial check, Action
	 */
	public ImportFileSummaryContainer() 
	{
		this.resultContainer = ImportCsvFirstStepView.getFlexVerticalLayout(false);
		
		Column<ImportAuditLineItem> fileName = summaryTable.addColumn(ImportAuditLineItem::getFileName).setHeader("File name")
				.setAutoWidth(true);
		Column<ImportAuditLineItem> fileSize = summaryTable.addColumn(ImportAuditLineItem::getFileSize).setHeader("File size")
				.setAutoWidth(true);
		Column<ImportAuditLineItem> healthStatus = summaryTable.addColumn(ImportAuditLineItem::getInitialCheck)
				.setHeader("Health status").setAutoWidth(true);
		Column<ImportAuditLineItem> rowCount = summaryTable.addColumn(ImportAuditLineItem::getRowCount).setHeader("Rows")
				.setAutoWidth(true);
		Column<ImportAuditLineItem> colCount = summaryTable.addColumn(ImportAuditLineItem::getRowCount).setHeader("Columns")
				.setAutoWidth(true);
		Column<ImportAuditLineItem> actionColumn = summaryTable.addComponentColumn(fileSummary -> createActionLayout(fileSummary))
				.setAutoWidth(true);

		summaryTable.setDataProvider(dataProvider);
		this.summaryTable.setWidthFull();
		this.summaryTable.setHeightFull();
	
		this.resultContainer.add(this.summaryTable);

	}

	private HorizontalLayout createActionLayout(ImportAuditLineItem fileSummary) 
	{
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

	public void addFileInfo(ImportAuditLineItem fileSummary) 
	{
		this.fileMap.put(fileSummary.getFileName(), fileSummary);
		this.dataProvider.refreshAll();
	}

	public void reset() 
	{
		
	}

	public FlexLayout getLayout() 
	{
		return this.resultContainer;
	}

}
