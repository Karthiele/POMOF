package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class JobsSearchPage extends LinkedInWrappers{

	public JobsSearchPage(){
		
		if(!verifyTitle("Search | LinkedIn")){

			Reporter.reportStep("The title did not match", "FAIL");
		}	
	}
	
	public JobsSearchPage verifyFirstViewButtonColor() {

		verifyViewButtonColor(prop.getProperty("JobsSearch.VerifyColor.Xpath"), prop.getProperty("JobsSearch.VerifyColor.Attribute"));
		return this;
	}
	
	public SecondJobPage clickSecondViewButton() {

		clickByXpath(prop.getProperty("JobsSearch.ClickView.Xpath"));
		return new SecondJobPage();
	}
}


