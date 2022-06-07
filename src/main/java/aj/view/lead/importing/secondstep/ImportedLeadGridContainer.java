package aj.view.lead.importing.secondstep;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.vaadin.componentfactory.enhancedgrid.EnhancedColumn;
import com.vaadin.componentfactory.enhancedgrid.EnhancedGrid;
import com.vaadin.flow.component.grid.GridSortOrder;
import com.vaadin.flow.component.grid.GridSortOrderBuilder;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.data.provider.InMemoryDataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;

import aj.csi.pim.lead.Lead;
import aj.view.lead.importing.firsstep.ImportCsvFirstStepView;

public class ImportedLeadGridContainer {

	private final FlexLayout holdingContainer;
	private final EnhancedGrid<Lead> goodBatchGrid = new EnhancedGrid<>();
	private Set<Lead> goodLeadSet = new LinkedHashSet<Lead>();
	private final InMemoryDataProvider<Lead> goodDp = new ListDataProvider<Lead>(goodLeadSet);

	public ImportedLeadGridContainer() {
		this.holdingContainer = ImportCsvFirstStepView.getFlexVerticalLayout(true);
		this.createEditableGrid(goodBatchGrid);
		this.goodBatchGrid.setWidthFull();
		this.holdingContainer.add(goodBatchGrid);
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

		// NumberRenderer<Lead> ageRenderer = new
		// NumberRenderer<Lead>(Lead::getSessionTime, "Age: %d");

		// EnhancedColumn<Lead> ageColumn = leadGrid.addColumn(ageRenderer)
		// .setComparator(Comparator.comparing(Lead::getSessionTime))
		// .setHeader("Age", new aj.TextFilterField());
		// ageColumn.setValueProvider(p -> String.valueOf(p.getSessionTime()));

		EnhancedColumn<Lead> createdDateColumn = leadGrid.addColumn(Lead::getCreatedDate).setHeader("Created Date");

		List<GridSortOrder<Lead>> sortByFirstName = new GridSortOrderBuilder<Lead>().thenDesc(firstNameColumn).build();
		leadGrid.sort(sortByFirstName);

		leadGrid.getColumns().forEach(col -> col.setAutoWidth(true));
	}

	public void loadGoodOnes(Set<Lead> leadSet) {
		this.goodLeadSet = leadSet;
		this.goodDp.refreshAll();
	}

}
