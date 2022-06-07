package aj.view.lead.importing.firsstep;

import java.util.LinkedHashSet;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

import aj.reusuables.ImportAuditLineItem;

public class ImportResponseLayout {
	
	private final FlexLayout holdingLayout;
	private final ComboBox<ImportAuditLineItem> fileList; 
	private final ImportGridContainer gridContainer;
	
	public ImportResponseLayout(LinkedHashSet<ImportAuditLineItem> resourceList)
	{
		this.holdingLayout  =  ImportCsvFirstStepView.getFlexVerticalLayout(true);
		this.fileList = new ComboBox<>();
		this.fileList.setItems(resourceList);
		this.fileList.setItemLabelGenerator(ImportAuditLineItem::getFileName);
		this.gridContainer = new ImportGridContainer();
		this.holdingLayout.add(this.fileList);
		this.holdingLayout.add(this.gridContainer.getLayout());		
	}
	
	public FlexLayout getLayout()
	{
		return this.holdingLayout;
	}

}
