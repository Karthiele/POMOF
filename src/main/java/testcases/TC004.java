package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LinkedInWrappers;

public class TC004 extends LinkedInWrappers{
	
	@BeforeClass
	public void executeBeforeClass(){
		
		dataSheetName="TC004";
		browserName="chrome";
		testCaseName="Test Case 04";
		testDescription="Test Case 04 using POM framework";
	}
	
	@Test(dataProvider="fetchData")
	public void executeTC002(String userName, String passWord, String verifyName, String keyWord){
		
		new LoginPage()
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickSignIn()
		.verifyUserName(verifyName)
		.clickJobs()
		.enterJobKeyWord(keyWord)
		.clickJobSearch()
		.verifyFirstViewButtonColor()
		.clickSecondViewButton()
		.printCompanyName()
		.clickCompanyName()
		.printEmployeesCount();
		
	}
}
