package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class JobsPage extends LinkedInWrappers{

	public JobsPage(){
		
		if(!verifyTitle("Jobs Home | LinkedIn")){

			Reporter.reportStep("The title did not match", "FAIL");
		}
	}
	
	public JobsPage enterJobKeyWord(String keyWord) {

		enterById(prop.getProperty("Jobs.Keyword.Id"), keyWord);
		return this;
	}
	
	public JobsSearchPage clickJobSearch() {

		clickByXpath(prop.getProperty("Jobs.Search.Xpath"));
		return new JobsSearchPage();
	}
	
	
}


