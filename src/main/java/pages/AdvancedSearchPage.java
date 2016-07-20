package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class AdvancedSearchPage extends LinkedInWrappers{

	public AdvancedSearchPage(){
		
		if(!verifyTitle("Search | LinkedIn")){

			Reporter.reportStep("The title did not match", "FAIL");
		}
	}
	
	public AdvancedSearchPage enterKeyword(String searchKey) {

		enterById(prop.getProperty("Adv.Keyword.Id"), searchKey);
		return this;
	}
	
	public SearchPage clickSearch(){
		
		clickByXpath(prop.getProperty("Adv.Search.Xpath"));
		return new SearchPage();
	}
	
	public SearchPage closeAdvancedSearchFrame(){
		
		clickByXpath(prop.getProperty("Adv.Close.Xpath"));
		return new SearchPage();
	}
	
}


