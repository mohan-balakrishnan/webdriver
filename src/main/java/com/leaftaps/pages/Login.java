package com.leaftaps.pages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectHooks;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Login extends ProjectHooks{
	@Given("Enter the username as {string}")
	public Login enterUsername(String data) {
		clearAndType(locateElement(Locators.NAME, "email"), data);
		reportStep("Username entered successfully","pass");
		return this;
	}
	
	@And("Enter the password as {string}")
	public Login enterPassword(String data) {
		clearAndType(locateElement(Locators.NAME, "password"), data);
		reportStep("Password entered successfully","pass");
		return this;
	}
	 
	@And("Click Login button")
	public Login clickLogin() {
		click(locateElement(Locators.CLASS_NAME, "login_button"));
		reportStep("Login button clicked successfully", "pass");
		return this;
	}
		
	@And("Click Continue button")
	public Login clickContinue() {
		click(locateElement(Locators.XPATH, "//button[text()='Continue']"));
		reportStep("Continue button clicked successfully", "pass");
		return this;
	}
	@And("Select Tenant")
	public Dashboard selectTenant() {
		click(locateElement(Locators.XPATH, "//h4[text()='lifetime pro plan']"));
		reportStep("Tenant selected successfully", "pass");
		return new Dashboard();
	}
}
