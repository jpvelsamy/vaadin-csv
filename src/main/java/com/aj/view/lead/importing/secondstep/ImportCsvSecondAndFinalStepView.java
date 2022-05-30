package com.aj.view.lead.importing.secondstep;

import javax.annotation.security.PermitAll;

import com.aj.view.lead.importing.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PermitAll
@Route(value = ImportCsvSecondAndFinalStepView.CSV_UPLOAD_STEP_2_ROUTE, layout = MainLayout.class)
@PageTitle(ImportCsvSecondAndFinalStepView.CSV_UPLOAD_STEP_2_TITLE)
public class ImportCsvSecondAndFinalStepView  extends Div implements HasUrlParameter<String>
{

	private static final long serialVersionUID = -4212394140208152018L;
	public static final String CSV_UPLOAD_STEP_2_TITLE = "Confirm upload leads";
	public static final String CSV_UPLOAD_STEP_2_ROUTE = "confirm-import";
	private final SecondStepCsvUploadResultsTopLayout resultsContainer;
	
	public ImportCsvSecondAndFinalStepView()
	{
		this.resultsContainer = new  SecondStepCsvUploadResultsTopLayout();
		FlexLayout resultsLayout = this.resultsContainer.getLayout();
		add(resultsLayout);
	}
	
	
	@Override
	public void setParameter(BeforeEvent event, @OptionalParameter String csvUploadAuditId)
	{
		
	}
}
