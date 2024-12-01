package com.leaftaps.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectHooks;

public class Dashboard extends ProjectHooks{
	
	public Dashboard verifyHomePage() {
		verifyDisplayed(locateElement(Locators.LINK_TEXT, "CRM/SFA"));
		reportStep("Homepage is loaded", "pass");
		return this;
	}
	
	public Dashboard clickCrmsfaLink() {
		click(locateElement(Locators.LINK_TEXT, "CRM/SFA"));
		reportStep("CRM/SFA link is clicked", "pass");
		return new Dashboard();
	}
	
}
