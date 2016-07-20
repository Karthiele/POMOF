package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LinkedInWrappers;

public class TC002 extends LinkedInWrappers{
	
	@BeforeClass
	public void executeBeforeClass(){
		
		dataSheetName="TC002";
		browserName="chrome";
		testCaseName="Test Case 02";
		testDescription="Test Case 02 using POM framework";
	}
	
	@Test(dataProvider="fetchData")
	public void executeTC002(String userName, String passWord, String verifyName) throws InterruptedException{
		
		new LoginPage()
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickSignIn()
		.verifyUserName(verifyName)
		.clickAdvanced()
		.closeAdvancedSearchFrame()
		.closeSecondConnection()
		.closeGroupConnection()
		.verifyFirstConnectionCount();
	}
}
