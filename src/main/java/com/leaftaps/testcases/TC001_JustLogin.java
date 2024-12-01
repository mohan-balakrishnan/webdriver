package com.leaftaps.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectHooks;
import com.leaftaps.pages.Login;
import com.leaftaps.pages.Dashboard;

public class TC001_JustLogin extends ProjectHooks{
	@BeforeTest
	public void setValues() {
		testcaseName = "Login";
		testDescription ="Login to Animaker";
		authors="Vignesh";
		category ="Smoke";
		excelFileName="Login";
	}
	
	@Test(dataProvider = "fetchData")
	public void runLogin(String email, String password) {
		new Login()
		.enterUsername(email)
		.enterPassword(password)
		.clickLogin()
		.clickContinue()
		.selectTenant();
		//.verifyHomePage();

	}

}
