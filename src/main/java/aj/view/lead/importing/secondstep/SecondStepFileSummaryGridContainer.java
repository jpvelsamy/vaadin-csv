package aj.view.lead.importing.secondstep;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.ContentAlignment;

import aj.view.lead.importing.ImportFileSummaryContainer;
import aj.view.lead.importing.firsstep.ImportCsvFirstStepView;

public class SecondStepFileSummaryGridContainer {
	
	private final FlexLayout holdingContainer;	 
	private final ImportFileSummaryContainer fileSummaryContainer;
	private final ImportAuditContainer auditContainer;
	
	
	public SecondStepFileSummaryGridContainer()
	{
		this.holdingContainer = ImportCsvFirstStepView.getFlexHorizontalLayout(false);
		this.holdingContainer.setAlignContent(ContentAlignment.STRETCH);
		this.holdingContainer.setAlignItems(Alignment.CENTER);
		this.holdingContainer.setJustifyContentMode(JustifyContentMode.EVENLY);
		this.fileSummaryContainer = new ImportFileSummaryContainer(true);
		FlexLayout gridLayout = this.fileSummaryContainer.getLayout();
		gridLayout.setSizeFull();
		gridLayout.setWidth(70, Unit.PERCENTAGE);
		
		this.auditContainer = new ImportAuditContainer();
		FlexLayout auditLayout = this.auditContainer.getLayout();
		auditLayout.setWidth(28, Unit.PERCENTAGE);
		
		
		
		this.holdingContainer.add(gridLayout);
		this.holdingContainer.add(auditLayout);
		
		
	}
	
	public FlexLayout getLayout()
	{
		return this.holdingContainer;
	}

}
