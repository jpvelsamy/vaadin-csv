package com.aj.view;

import com.vaadin.flow.component.orderedlayout.FlexLayout;

public class ImportResultsContainer {
	
	private final FlexLayout flexLayout;
	
	public ImportResultsContainer()
	{
		this.flexLayout = new FlexLayout();		
	}
	
	
	
	public FlexLayout getLayout()
	{
		return this.flexLayout;
	}

}
