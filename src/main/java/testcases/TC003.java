package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LinkedInWrappers;

public class TC003 extends LinkedInWrappers{
	
	@BeforeClass
	public void executeBeforeClass(){
		
		dataSheetName="TC003";
		browserName="chrome";
		testCaseName="Test Case 03";
		testDescription="Test Case 03 using POM framework";
	}
	
	@Test(dataProvider="fetchData")
	public void executeTC002(String userName, String passWord, String verifyName, String orgName, String skill) throws InterruptedException{
		
		new LoginPage()
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickSignIn()
		.verifyUserName(verifyName)
		.clickProfile()
		.verifyCurrentOrganization(orgName)
		.verifyAndAddSkill(skill)
		.verifyAddedSkill(skill);
		
	}
}
