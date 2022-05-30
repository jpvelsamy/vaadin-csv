package com.aj.view;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.aj.ToasterForAdBuddy;
import com.vaadin.componentfactory.enhancedgrid.EnhancedColumn;
import com.vaadin.componentfactory.enhancedgrid.EnhancedGrid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.GridSortOrder;
import com.vaadin.flow.component.grid.GridSortOrderBuilder;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.provider.InMemoryDataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.NumberRenderer;

import aj.csi.pim.lead.Lead;

public class ImportGridContainer {
	private final FlexLayout holdingContainer;
	private final EnhancedGrid<Lead> goodBatchGrid = new EnhancedGrid<>();
	private final EnhancedGrid<Lead> badBatchGrid = new EnhancedGrid<>();
	private final EnhancedGrid<Lead> uglyBatchGrid = new EnhancedGrid<>();
	private Set<Lead> goodLeadSet = new LinkedHashSet<Lead>();
	private Set<Lead> badLeadSet = new LinkedHashSet<Lead>();
	private Set<Lead> uglyLeadSet = new LinkedHashSet<Lead>();
	private final InMemoryDataProvider<Lead> goodDp = new ListDataProvider<Lead>(goodLeadSet);
	private final InMemoryDataProvider<Lead> badDp = new ListDataProvider<Lead>(badLeadSet);
	private final InMemoryDataProvider<Lead> uglyDp = new ListDataProvider<Lead>(uglyLeadSet);
	private final ToasterForAdBuddy toastr = new ToasterForAdBuddy();

	public ImportGridContainer() {
		this.holdingContainer = ImportCsvFirstStepView.getFlexVerticalLayout(true);
		this.createEditableGrid(goodBatchGrid);
		goodBatchGrid.setWidthFull();
		this.createEditableGrid(badBatchGrid);
		badBatchGrid.setWidthFull();
		this.createEditableGrid(uglyBatchGrid);
		uglyBatchGrid.setWidthFull();
		this.holdingContainer.add(goodBatchGrid);
		this.holdingContainer.add(badBatchGrid);
		this.holdingContainer.add(uglyBatchGrid);
	}

	public FlexLayout getLayout() {
		return this.holdingContainer;
	}

	private void createEditableGrid(EnhancedGrid<Lead> leadGrid) {
		EnhancedColumn<Lead> firstNameColumn = (EnhancedColumn<Lead>) leadGrid.addColumn(Lead::getFirstName)
				.setHeader("First Name");

		EnhancedColumn<Lead> lastNameColumn = (EnhancedColumn<Lead>) leadGrid.addColumn(Lead::getLastName)
				.setHeader("Last Name");

		EnhancedColumn<Lead> emailIdColumn = (EnhancedColumn<Lead>) leadGrid.addColumn(Lead::getEmailId)
				.setHeader("Email");

		EnhancedColumn<Lead> contactNoColumn = (EnhancedColumn<Lead>) leadGrid.addColumn(Lead::getPhoneNumber)
				.setHeader("Contact");

		EnhancedColumn<Lead> campaignNameColumn = (EnhancedColumn<Lead>) leadGrid.addColumn(Lead::getCampaignName)
				.setHeader("Campaign Name");

		EnhancedColumn<Lead> platformTypeColumn = (EnhancedColumn<Lead>) leadGrid.addColumn(Lead::getPlatformType)
				.setHeader("PlatFormType");

		EnhancedColumn<Lead> owneruserIdColumn = (EnhancedColumn<Lead>) leadGrid.addColumn(Lead::getOwnerUserId)
				.setHeader("Assigned To");

		EnhancedColumn<Lead> dueDateColumn = (EnhancedColumn<Lead>) leadGrid.addColumn(Lead::getDueDate)
				.setHeader("Due Date");

		EnhancedColumn<Lead> modifieddateColumn = (EnhancedColumn<Lead>) leadGrid.addColumn(Lead::getModifiedDate)
				.setHeader("Modified Date");

		//NumberRenderer<Lead> ageRenderer = new NumberRenderer<Lead>(Lead::getSessionTime, "Age: %d");

		//EnhancedColumn<Lead> ageColumn = leadGrid.addColumn(ageRenderer)
				//.setComparator(Comparator.comparing(Lead::getSessionTime))
				//.setHeader("Age", new com.aj.TextFilterField());
		//ageColumn.setValueProvider(p -> String.valueOf(p.getSessionTime()));

		EnhancedColumn<Lead> createdDateColumn = leadGrid.addColumn(Lead::getCreatedDate).setHeader("Created Date");

		Column<Lead> actionColumn = leadGrid.addComponentColumn(fileSummary -> createActionLayout(fileSummary));
		
		List<GridSortOrder<Lead>> sortByFirstName = new GridSortOrderBuilder<Lead>().thenDesc(firstNameColumn)
				.build();
		leadGrid.sort(sortByFirstName);
		

		leadGrid.getColumns().forEach(col -> col.setAutoWidth(true));
	}

	public void loadGoodOnes(Set<Lead> leadSet) {
		this.goodLeadSet = leadSet;
		this.goodDp.refreshAll();
	}
	
	public void loadBadOnes(Set<Lead> leadSet) {
		this.badLeadSet = leadSet;
		this.badDp.refreshAll();
	}
	
	
	public void loadUglyOnes(Set<Lead> leadSet) {
		this.uglyLeadSet = leadSet;
		this.uglyDp.refreshAll();
	}

	private HorizontalLayout createActionLayout(Lead fileSummary) {
		final Button processButton = new Button("Import");
		final Button deleteButton = new Button("Delete");
		final HorizontalLayout actionLayout = new HorizontalLayout(processButton, deleteButton);
		processButton.addClickListener(event -> {
			// Do the processing and change the status

		});
		deleteButton.addClickListener(event -> {

		});
		return actionLayout;
	}

}
