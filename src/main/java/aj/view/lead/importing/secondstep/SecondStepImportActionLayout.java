package aj.view.lead.importing.secondstep;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

import aj.view.lead.importing.firsstep.ImportCsvFirstStepView;

public class SecondStepImportActionLayout {
	
	private final FlexLayout actionLayout;
	
	public SecondStepImportActionLayout()
	{
		this.actionLayout = ImportCsvFirstStepView.getFlexHorizontalLayout(false);
		this.actionLayout.setJustifyContentMode(JustifyContentMode.EVENLY);
		
		
		ImportActionContainer all = new ImportActionContainer("Import all", ImportActionContainer.IMPORT_MODE_ALL);
		ImportActionContainer selected = new ImportActionContainer("Import clean", ImportActionContainer.IMPORT_MODE_CLEAN);
		
		Div holdingDivAll = all.getHoldingDiv();
		Div holdingDivClean =  selected.getHoldingDiv();
		
		this.actionLayout.add(holdingDivAll);
		this.actionLayout.add(holdingDivClean);
		
	}
	
	public FlexLayout getLayout()
	{
		return this.actionLayout;
	}

}
