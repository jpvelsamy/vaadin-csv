package com.aj.view;

import javax.annotation.security.PermitAll;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.ContentAlignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexDirection;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexWrap;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PermitAll
@Route(value = ImportCsvFirstStepView.CSV_UPLOAD_STEP_1_ROUTE, layout = MainLayout.class)
@PageTitle(ImportCsvFirstStepView.CSV_UPLOAD_STEP_1_TITLE)
public class ImportCsvFirstStepView extends Div {

	private static final long serialVersionUID = -4212394140208152018L;
	public static final String CSV_UPLOAD_STEP_1_ROUTE = "";
	public static final String CSV_UPLOAD_STEP_1_TITLE = "Upload leads by csv";
	private CsvImportRootLayout rootLayout;
	

	public ImportCsvFirstStepView() {
		createMainLayout();
	}

	private void createMainLayout() {
		rootLayout = new CsvImportRootLayout();
		FlexLayout rootFlexLayout = rootLayout.getRoot();	
		add(rootFlexLayout);
	}

	public static FlexLayout getFlexVerticalLayout(boolean wrap) {
		FlexLayout flexLayout = new FlexLayout();
		flexLayout.setWidthFull();
		flexLayout.setFlexDirection(FlexDirection.COLUMN);
		flexLayout.setFlexWrap(wrap ? FlexWrap.WRAP : FlexWrap.NOWRAP);
		flexLayout.setAlignContent(ContentAlignment.START);
		return flexLayout;
	}

	public static FlexLayout getFlexHorizontalLayout(boolean wrap) {
		FlexLayout flexLayout = new FlexLayout();
		flexLayout.setWidthFull();
		flexLayout.setFlexDirection(FlexDirection.ROW);
		flexLayout.setFlexWrap(wrap ? FlexWrap.WRAP : FlexWrap.NOWRAP);
		flexLayout.setAlignContent(ContentAlignment.START);
		return flexLayout;
	}
}
