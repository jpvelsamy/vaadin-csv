package aj.view.lead.importing.secondstep;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.ContentAlignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import aj.view.lead.importing.firsstep.ImportCsvFirstStepView;

public class SecondStepImportSummaryRowLayout {
	private static final String VAR_LUMO_SUCCESS_COLOR_10PCT = "var(--lumo-success-color-10pct)";
	private static final String VAR_LUMO_PRIMARY_COLOR_10PCT = "var(--lumo-primary-color-10pct)";
	private static final String VAR_LUMO_ERROR_COLOR_10PCT = "var(--lumo-error-color-10pct)";
	private static final String VAR_LUMO_PRIMARY_COLOR_20PCT = "var(--lumo-primary-color-10pct)";
	private final FlexLayout reportCountFirstRowContainer;
	private final SecondStepImportDownloadLinkContainer actionLayoutBuilder;
	
	public SecondStepImportSummaryRowLayout()
	{
		this.reportCountFirstRowContainer = ImportCsvFirstStepView.getFlexHorizontalLayout(false);
		this.reportCountFirstRowContainer.setJustifyContentMode(JustifyContentMode.EVENLY);
		this.reportCountFirstRowContainer.setAlignItems(Alignment.CENTER);
		this.reportCountFirstRowContainer.setAlignContent(ContentAlignment.SPACE_BETWEEN);
		createFileCircle();
		createRowCircle();
		createImportedCircle();
		createChangedRowsCircle();
		actionLayoutBuilder = new SecondStepImportDownloadLinkContainer();
		createDownloadLinks();

		
	}
	
	private void createDownloadLinks()
	{
		Div holdingDiv = new Div();
		VerticalLayout actionLayout = actionLayoutBuilder.getLayout();
		holdingDiv.add(actionLayout);
		this.reportCountFirstRowContainer.add(holdingDiv);
	}
	
	private void createChangedRowsCircle()
	{
		String color = VAR_LUMO_PRIMARY_COLOR_20PCT;
		String header = "Changed rows";
		String countValue = "200";

		Div extDiv = createDataWidget(color, header, countValue);

		this.reportCountFirstRowContainer.add(extDiv);
	}
	
	private void createImportedCircle() {
		String color = VAR_LUMO_ERROR_COLOR_10PCT;
		String header = "Imported rows";
		String countValue = "1000";

		Div extDiv = createDataWidget(color, header, countValue);

		this.reportCountFirstRowContainer.add(extDiv);
	}

	private void createRowCircle() {
		String color = VAR_LUMO_PRIMARY_COLOR_10PCT;
		String header = "Total rows";
		String countValue = "1300";

		Div extDiv = createDataWidget(color, header, countValue);

		this.reportCountFirstRowContainer.add(extDiv);
	}

	private void createFileCircle() {
		String color = VAR_LUMO_SUCCESS_COLOR_10PCT;
		String header = "Total files";
		String countValue = "13";

		Div extDiv = createDataWidget(color, header, countValue);

		this.reportCountFirstRowContainer.add(extDiv);
	}

	

	public FlexLayout getLayout() {
		return this.reportCountFirstRowContainer;
	}

	private Div createDataWidget(String color, String header, String countValue) {
		Div extDiv = createExternalDiv();
		Div containerDiv = createCircle(color);
		H2 headerLabel = new H2(header);
		Paragraph rowLabel = new Paragraph(countValue);
		containerDiv.add(headerLabel);
		containerDiv.add(rowLabel);
		extDiv.add(containerDiv);
		return extDiv;
	}
	
	private Div createExternalDiv() {
		Div ext3Div = new Div();
		ext3Div.getStyle().set("display", "table");
		return ext3Div;
	}
	
	private Div createCircle(String color) {
		Div totalFilesDiv = new Div();
		totalFilesDiv.getStyle().set("display", "table-cell");
		totalFilesDiv.getStyle().set("text-align", "center");
		totalFilesDiv.getStyle().set("background-color", color);
		totalFilesDiv.getStyle().set("width", "250px");
		totalFilesDiv.getStyle().set("height", "70px");
		//totalFilesDiv.getStyle().set("border-radius", "50%");
		return totalFilesDiv;
	}

	
	
	
}
