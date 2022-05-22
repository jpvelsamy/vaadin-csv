package com.aj.view;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.aj.view.table.Table;
import com.aj.view.table.TableBody;
import com.aj.view.table.TableHead;
import com.aj.view.table.TableHeaderCell;
import com.aj.view.table.TableRow;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ImportFileSummaryContainer {

	private final FlexLayout container;
	private final Table summaryContentTable;
	private final AtomicInteger counter = new AtomicInteger(1);
	private final Map<String, FileSummary> fileMap = new LinkedHashMap<String, FileSummary>();
	private final TableBody body;

	/**
	 * S.No, File Name, File size, Initial check, Action
	 */
	public ImportFileSummaryContainer() {
		this.container = new FlexLayout();
		this.summaryContentTable = new Table();
		final TableHead head = summaryContentTable.getHead();
		final TableRow headerRow = head.addRow();
		final TableHeaderCell serialNo = headerRow.addHeaderCell();
		serialNo.setText("S No");
		final TableHeaderCell fileName = headerRow.addHeaderCell();
		fileName.setText("Name");
		final TableHeaderCell fileSize = headerRow.addHeaderCell();
		fileSize.setText("Size");
		final TableHeaderCell rowAndColCount = headerRow.addHeaderCell();
		rowAndColCount.setText("Col/Row");
		final TableHeaderCell initialCheck = headerRow.addHeaderCell();
		initialCheck.setText("Healthy");
		final TableHeaderCell status = headerRow.addHeaderCell();
		status.setText("Status");
		this.container.add(this.summaryContentTable);
		this.body = this.summaryContentTable.getBody();
	}

	public void addFileInfo(FileSummary fileSummary) {
		this.fileMap.put(fileSummary.getFileName(), fileSummary);
		final Button processButton = new Button("Process");
		final Button deleteButton = new Button("Delete");
		final HorizontalLayout actionLayout = new HorizontalLayout(processButton, deleteButton);
		
		final TableRow fileRow = body.addRow();
		int currentValue = counter.incrementAndGet();
		fileRow.addCells(Integer.toString(currentValue));
		fileRow.addCells(fileSummary.getFileName());
		fileRow.addCells(fileSummary.getFileSize());
		fileRow.addCells(fileSummary.getHealthStatus());
		fileRow.addCells(actionLayout);
		processButton.addClickListener(event -> {
			// Do the processing and change the status
			processButton.setEnabled(false);
			processButton.setText("PROCESSED");
		});
		deleteButton.addClickListener(event->{
			this.body.removeRows(fileRow);
		});

	}

	public void reset() {
		this.body.removeAllRows();
	}
	
	public FlexLayout getLayout()
	{
		return this.container;
	}

}
