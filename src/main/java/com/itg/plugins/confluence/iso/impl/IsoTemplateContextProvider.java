package com.itg.plugins.confluence.iso.impl;

import javax.inject.Inject;

import com.atlassian.confluence.languages.LocaleManager;
import com.atlassian.confluence.plugins.createcontent.api.contextproviders.AbstractBlueprintContextProvider;
import com.atlassian.confluence.plugins.createcontent.api.contextproviders.BlueprintContext;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.itg.plugins.confluence.iso.api.IsoDocumentService;

import static com.atlassian.confluence.plugins.createcontent.actions.DefaultBlueprintContentGenerator.CONTENT_PAGE_TITLE_CONTEXT_KEY;

public class IsoTemplateContextProvider extends AbstractBlueprintContextProvider {
	
	@ComponentImport
	private final LocaleManager _localeManager;
	
	private final IsoDocumentService _isoDocumentService;
	
	@Inject
	public IsoTemplateContextProvider(LocaleManager localeManager, IsoDocumentService isoDocumentService)
	{
	    this._localeManager = localeManager;
	    this._isoDocumentService = isoDocumentService;
	}
	
	@Override
	protected BlueprintContext updateBlueprintContext(BlueprintContext ctx)
	{
	    final String pageTitle = _isoDocumentService.getPageTitle();
	    ctx.put(CONTENT_PAGE_TITLE_CONTEXT_KEY, pageTitle);
	
	    //Page parentpage = getPage("test", pageTitle);
	    /*Space parentspace = manager.getSpace("ET");
	    Page newpage = new Page();
	    newpage.setTitle("Java Page");
	    newpage.setSpace(parentspace);
	    System.out.println("Created new page");*/
	    //parentpage.addChild(newpage);
	
	    return ctx;
	}
}