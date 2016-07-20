package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LinkedInWrappers;

public class TC001 extends LinkedInWrappers{
	
	@BeforeClass
	public void executeBeforeClass(){
		
		dataSheetName="TC001";
		browserName="chrome";
		testCaseName="Test Case 0001";
		testDescription="Test Case 01 using POM framework";
	}
	
	@Test(dataProvider="fetchData")
	public void executeTC001(String userName, String passWord, String verifyName, String searchKey){
		
		new LoginPage()
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickSignIn()
		.verifyUserName(verifyName)
		.clickAdvanced()
		.enterKeyword(searchKey)
		.clickSearch()
		.searchResultCount()
		.printFirstDisplayedConnectionName()
		.verifyConnectionType();
	}
}
