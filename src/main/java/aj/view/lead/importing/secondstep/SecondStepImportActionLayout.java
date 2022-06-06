package aj.view.lead.importing.secondstep;

import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import aj.view.lead.importing.firsstep.ImportCsvFirstStepView;

public class SecondStepImportActionLayout {
	
	private final FlexLayout actionLayout;
	
	public SecondStepImportActionLayout()
	{
		this.actionLayout = ImportCsvFirstStepView.getFlexHorizontalLayout(false);
		this.actionLayout.setJustifyContentMode(JustifyContentMode.EVENLY);
		
		
		ImportActionContainer all = new ImportActionContainer("Import all", ImportActionDivContainer.IMPORT_MODE_ALL);
		ImportActionContainer selected = new ImportActionContainer("Import clean", ImportActionDivContainer.IMPORT_MODE_CLEAN);
		
		VerticalLayout holdingDivAll = all.getLayout();
		VerticalLayout holdingDivClean =  selected.getLayout();
		
		this.actionLayout.add(holdingDivAll);
		this.actionLayout.add(holdingDivClean);
		
	}
	
	public FlexLayout getLayout()
	{
		return this.actionLayout;
	}

}
