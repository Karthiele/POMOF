package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class SecondJobPage extends LinkedInWrappers{

	public SecondJobPage(){
		
		if(!verifyTitleContains("LinkedIn")){

			Reporter.reportStep("The title did not match", "FAIL");
		}	
	}
	
	public SecondJobPage printCompanyName() {

		printCompanyNameByXpath(prop.getProperty("SecondJob.CompanyName.Xpath"));
		return this;
	}
	
	public SecondCompanyPage clickCompanyName() {

		clickByXpath(prop.getProperty("SecondJob.CompanyName.Xpath"));
		return new SecondCompanyPage();
	}
}


