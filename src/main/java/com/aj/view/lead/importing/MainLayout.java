package com.aj.view.lead.importing;

import com.aj.view.lead.importing.firsstep.ImportCsvFirstStepView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

	private static final long serialVersionUID = -2367575791855548860L;

	public MainLayout() {	
		createHeader();
		createDrawer();
	}

	private void createHeader() {
		H1 logo = new H1("Vaadin CRM");
		logo.addClassNames("text-l", "m-m");		

		HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);

		header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
		header.expand(logo);
		header.setWidth("100%");
		header.addClassNames("py-0", "px-m");

		addToNavbar(header);

	}

	private void createDrawer() {
		RouterLink catalogLink = new RouterLink("Catalogue", ImportCsvFirstStepView.class);
		addToDrawer(new VerticalLayout(  catalogLink));
	}
}