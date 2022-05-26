package com.aj.view;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.vaadin.componentfactory.NoScrollGrid;

import com.aj.reusuables.ResourceSummary;
import com.aj.view.table.Table;
import com.aj.view.table.TableHead;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.provider.InMemoryDataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;

public class ImportFileSummaryContainer {

	private final FlexLayout resultContainer;
	private final NoScrollGrid<ResourceSummary> summaryTable = new NoScrollGrid<ResourceSummary>();
	private final AtomicInteger counter = new AtomicInteger(1);
	private final Map<String, ResourceSummary> fileMap = new LinkedHashMap<String, ResourceSummary>();
	private final InMemoryDataProvider<ResourceSummary> dataProvider = new ListDataProvider<>(fileMap.values());
	
	/**
	 * S.No, File Name, File size, Initial check, Action
	 */
	public ImportFileSummaryContainer() 
	{
		this.resultContainer = new FlexLayout();
		
		Column<ResourceSummary> fileName = summaryTable.addColumn(ResourceSummary::getFileName).setHeader("File name")
				.setAutoWidth(true);
		Column<ResourceSummary> fileSize = summaryTable.addColumn(ResourceSummary::getFileSize).setHeader("File size")
				.setAutoWidth(true);
		Column<ResourceSummary> healthStatus = summaryTable.addColumn(ResourceSummary::getInitialCheck)
				.setHeader("Health status").setAutoWidth(true);
		Column<ResourceSummary> rowCount = summaryTable.addColumn(ResourceSummary::getRowCount).setHeader("Rows")
				.setAutoWidth(true);
		Column<ResourceSummary> colCount = summaryTable.addColumn(ResourceSummary::getRowCount).setHeader("Columns")
				.setAutoWidth(true);
		Column<ResourceSummary> actionColumn = summaryTable.addComponentColumn(fileSummary -> createActionLayout(fileSummary))
				.setAutoWidth(true);

		summaryTable.setDataProvider(dataProvider);
		
	
		this.resultContainer.add(this.summaryTable);

	}

	private HorizontalLayout createActionLayout(ResourceSummary fileSummary) 
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

	public void addFileInfo(ResourceSummary fileSummary) 
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
