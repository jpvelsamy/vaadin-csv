package aj.view.lead.importing.secondstep;

import org.vaadin.componentfactory.NoScrollGrid;

import com.vaadin.flow.component.orderedlayout.FlexLayout;

import aj.reusuables.ImportAuditLineItem;
import aj.view.lead.importing.firsstep.ImportCsvFirstStepView;

public class SecondStepFileSummaryContainer {
	
	private final FlexLayout holdingContainer;
	private final NoScrollGrid<ImportAuditLineItem> fileSummaryGrid;
	
	
	public SecondStepFileSummaryContainer()
	{
		this.holdingContainer = ImportCsvFirstStepView.getFlexVerticalLayout(false);
		this.fileSummaryGrid = new NoScrollGrid<>(20);
		this.fileSummaryGrid.setWidthFull();		
		


		this.fileSummaryGrid.addColumn("Imported On");
		this.holdingContainer.add(this.fileSummaryGrid);
	}
	
	public FlexLayout getLayout()
	{
		return this.holdingContainer;
	}

}
