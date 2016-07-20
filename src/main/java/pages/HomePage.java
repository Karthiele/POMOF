package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class HomePage extends LinkedInWrappers{

	public HomePage(){
		
		if(!verifyTitle("Welcome! | LinkedIn")){

			Reporter.reportStep("The title did not match", "FAIL");
		}
	}
	
	public HomePage verifyUserName(String verifyName){
		
		verifyTextContainsByXpath(prop.getProperty("Home.UserName.Xpath"), verifyName);
		return this;
	}
	
	public AdvancedSearchPage clickAdvanced(){
		
		clickById(prop.getProperty("Home.AdvancedSearch.Id"));
		return new AdvancedSearchPage();
	}
	
	public ProfilePage clickProfile(){
		
		clickByXpath(prop.getProperty("Home.Profile.Xpath"));
		return new ProfilePage();
	}
	
	public JobsPage clickJobs(){
		
		clickByXpath(prop.getProperty("Home.Jobs.Xpath"));
		return new JobsPage();
	}
}
