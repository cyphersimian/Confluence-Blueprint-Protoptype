package com.itg.plugins.confluence.iso.impl;

import com.atlassian.confluence.plugins.createcontent.api.events.BlueprintPageCreateEvent;
import com.atlassian.event.api.EventListener;
import com.atlassian.event.api.EventPublisher;
import com.atlassian.plugin.ModuleCompleteKey;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.confluence.pages.Page;
import com.atlassian.confluence.pages.PageManager;
import com.atlassian.confluence.spaces.Space;
import com.atlassian.confluence.spaces.SpaceManager;
import com.atlassian.confluence.spaces.SpacesQuery;
import java.util.List;

import javax.inject.Inject;


public class IsoDocumentTemplateListener {
	private static final ModuleCompleteKey MY_BLUEPRINT_KEY = new ModuleCompleteKey("com.itg.plugins.confluence.iso", "iso-documentation");
	private static final Logger log = LoggerFactory.getLogger(IsoDocumentTemplateListener.class);
	private SpaceManager manager;
	private SpacesQuery query;

	@Inject
	public IsoDocumentTemplateListener(EventPublisher eventPublisher) {
			eventPublisher.register(this);
	}

	@EventListener
	public void onBlueprintCreateEvent(BlueprintPageCreateEvent event){

		ModuleCompleteKey moduleCompleteKey = event.getBlueprintKey();

	  	if (MY_BLUEPRINT_KEY.equals(moduleCompleteKey)){
	  			//Take some action when
	  			log.warn("WARN: Created a blueprint.");
	        Space parentspace;
	        List<String> stringList;
	        List<Space> spaceList;
	        try{
	            spaceList = manager.getAllSpaces(query);
	            stringList = query.getSpaceKeys();
	            log.warn("Spaces:" + stringList.get(0));
	            parentspace = manager.getSpace(stringList.get(0));
	        }catch(Exception e){
	          log.warn("WARN: " + e.getMessage());
	        }
	          Page newpage = new Page();
	          log.warn("WARN: Initiating page.");
	          newpage.setTitle("Java Page 2");
	          log.warn("WARN: Set page title.");
	        }
	  	}
}