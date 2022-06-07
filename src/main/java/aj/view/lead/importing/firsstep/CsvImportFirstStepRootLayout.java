package aj.view.lead.importing.firsstep;

import java.util.LinkedHashSet;

import org.vaadin.miki.superfields.buttons.ButtonState;
import org.vaadin.miki.superfields.buttons.MultiClickButton;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

import aj.reusuables.ImportAuditLineItem;
import aj.view.lead.importing.secondstep.ImportCsvSecondAndFinalStepView;

/*
 * TODO 
 * 1. Need to add long running transaction
 * 2. Need to add reset button
 * 3. Need to add a input file table with a process button
 * 4. Need to add summary section at the end 
 */
public class CsvImportFirstStepRootLayout {

	private final FlexLayout holdingLayout;
	private final FlexLayout resetButtonLayout;
	private final ImportActionSummaryLayout actionSummaryLayout;
	private final ImportResponseLayout responseGridLayout;
	private final FlexLayout confirmAndProceedButtonLayout;
	
	/**
	 * We have to add a Table to show the post upload result
	 * S.No, File Name, File size, Initial check, Action
	 */
	public CsvImportFirstStepRootLayout()
	{
		holdingLayout = ImportCsvFirstStepView.getFlexVerticalLayout(false);
		holdingLayout .setWidth("unset");
		
		Button resetButton = new Button("Reset All");
		resetButtonLayout = new FlexLayout(resetButton);
		resetButtonLayout.setJustifyContentMode(JustifyContentMode.END);		
		holdingLayout.add(resetButtonLayout);
		
		actionSummaryLayout = new ImportActionSummaryLayout();		
		FlexLayout importActionAndSummaryLayout = actionSummaryLayout.getLayout();		
		holdingLayout.add(importActionAndSummaryLayout);
		responseGridLayout = new ImportResponseLayout(new LinkedHashSet<ImportAuditLineItem>());
		
		FlexLayout gridLayout = responseGridLayout.getLayout();
		holdingLayout.add(gridLayout);
		
		Button confirmButton  = new Button("1. Confirm");
		ButtonState confirmButtonState = ButtonState.of(confirmButton);
		Button proceedButton  = new Button("2. Proceed");
		proceedButton.setEnabled(false);
		confirmButton.addClickListener(event->{
			proceedButton.setEnabled(true);
		});
		proceedButton.addClickListener(event->{
			confirmButton.setEnabled(false);
		});
		ButtonState proceedButtonState = ButtonState.of(proceedButton);
		MultiClickButton confirmAndProceedButton = new MultiClickButton(confirmButtonState, proceedButtonState);
		confirmAndProceedButton.addClickListener(event->{
			holdingLayout.getUI().ifPresent(ui -> ui.navigate(ImportCsvSecondAndFinalStepView.CSV_UPLOAD_STEP_2_ROUTE));
		});
		confirmAndProceedButtonLayout = new FlexLayout(confirmAndProceedButton);
		confirmAndProceedButtonLayout.setJustifyContentMode(JustifyContentMode.END);
		holdingLayout.add(confirmAndProceedButtonLayout);
		
	}
	
	public FlexLayout getRoot()
	{
		return this.holdingLayout;
	}
	
}
