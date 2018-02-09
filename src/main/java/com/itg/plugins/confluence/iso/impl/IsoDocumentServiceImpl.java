package com.itg.plugins.confluence.iso.impl;

import com.atlassian.confluence.languages.LocaleManager;
import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.atlassian.confluence.user.ConfluenceUser;
import com.atlassian.confluence.user.UserAccessor;
import com.atlassian.confluence.util.i18n.I18NBeanFactory;
import com.atlassian.confluence.xhtml.api.EditorFormatService;
import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.ApplicationProperties;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;

import com.itg.plugins.confluence.iso.api.IsoDocumentService;

@ExportAsService ({IsoDocumentService.class})
@Named ("IsoDocumentService")
public class IsoDocumentServiceImpl implements IsoDocumentService

{
	@Nonnull
	@ComponentImport
	private final UserAccessor _userAccessor;
    @Nonnull 
    @ComponentImport
    private final LocaleManager _localeManager; 
	@Nonnull
    @ComponentImport
    private final ApplicationProperties _applicationProperties;
	@Nonnull
    @ComponentImport
    private final EditorFormatService _editorFormatService;
	@Nonnull
    @ComponentImport
	private final I18NBeanFactory _i18NBeanFactory;
	
    @Inject
    public IsoDocumentServiceImpl(
    		final ApplicationProperties applicationProperties,
    		final UserAccessor userAccessor,
    		final LocaleManager localeManager,
    		final EditorFormatService editorFormatService,
    		final I18NBeanFactory i18NBeanFactory) {
		
    	this._userAccessor = userAccessor;	
		this._localeManager = localeManager;
        this._applicationProperties = applicationProperties;
        this._editorFormatService = editorFormatService;
        this._i18NBeanFactory = i18NBeanFactory;
    }

    public String getName()
    {
        if(null != _applicationProperties)
        {
            return "myComponent:" + _applicationProperties.getDisplayName();
        }
        
        return "myComponent";
    }

	public String getPageTitle() {
		
		// TODO Auto-generated method stub
		return "The name of my New Document";
	}

	//@Override
	public String getFriendlyDate() {
		
		return DateFormat.getDateInstance(DateFormat.LONG).format(new Date());
	}

	//@Override
	public String getFriendlyDateTime() {
		
		return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(new Date());
	}

	//@Override
	public ConfluenceUser getUser(String userName) {
		
		return _userAccessor.getUserByName(userName);
	}

	//@Override
	public ConfluenceUser getCurrentUser() {
		
		return AuthenticatedUserThreadLocal.get(); 
	}

	//@Override
	public String getClientLogoPath(String clientId) {
		// TODO Auto-generated method stub
		return null;
	}
 
	//@Override
	public Locale getCurrentLocale() {
		
		return getCurrentUser() != null ? (Locale)_localeManager.getLocale(getCurrentUser()) : null;
	}

	/*	@Override
	public Map<String, Object> getContextMap(Map<String, Object> ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@EventListener
	@Override
    public void init(Map<String, String> params) throws PluginParseException {
    }
 
    @Override
    public Map<String, Object> getContextMap(Map<String, Object> ctx) {
        try {
        	for(Iterator<String> key = ctx.keySet().iterator(); key.hasNext();) {
        		String keyItem = key.next();
        		//We're only looking for "wiki" items here
        		if(keyItem.substring(0, 4) == "wiki") {
        			String wikiMarkup = (String) ctx.get(keyItem);
        			String xhtml = _editorFormatService.convertWikiToEdit(wikiMarkup, new DefaultConversionContext(new PageContext()));
        			ctx.put(keyItem.concat("Xhtml"), xhtml);
        		}
        	
        		//now we've added the users inputs let's put some defaults in
        		//final String pageTitle = i18nBean().getText("varBriefTitle");
        		
        		ctx.put(CONTENT_PAGE_TITLE_CONTEXT_KEY, i18nBean().getText("varBriefTitle"));
        		ctx.put("varDate", DateFormat.getDateInstance(DateFormat.LONG).format(new Date()));
        	}
        	
        } catch (XhtmlException ignored) {
        }
        return ctx;
    }
    
    private I18NBean i18nBean()
    {
        return _i18NBeanFactory.getI18NBean(_localeManager.getLocale(getCurrentUser()));
    }*/
}
