package com.itg.plugins.confluence.iso.api;

import java.util.Locale;

import com.atlassian.confluence.user.ConfluenceUser;

public interface IsoDocumentService {
	
	public String getPageTitle();
	
	public String getFriendlyDate();
	
	public String getFriendlyDateTime();
	
	public ConfluenceUser getUser(String userName);
	
	public ConfluenceUser getCurrentUser();
	
	public String getClientLogoPath(String clientId);
	
	public Locale getCurrentLocale();
}
