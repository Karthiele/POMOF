package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class SearchPage extends LinkedInWrappers{

	public SearchPage(){
		
		if(!verifyTitle("Search | LinkedIn")){

			Reporter.reportStep("The title did not match", "FAIL");
		}
	}
	
	public SearchPage searchResultCount(){

		resultCountById(prop.getProperty("Search.Result.Id"));
		return this;
	}
	
	public SearchPage printFirstDisplayedConnectionName(){

		printConnectionByXpath(prop.getProperty("Search.Print.Xpath"));
		return this;
	}
	
	public SearchPage verifyConnectionType(){
		
		verifyConnectionTypeByXpath(prop.getProperty("Search.Verify.Xpath"));
		return this;
	}
	
	public SearchPage closeSecondConnection(){
		
		clickByXpath(prop.getProperty("Search.CloseSecond.Xpath"));
		return this;
	}

	public SearchPage closeGroupConnection(){
	
	clickByXpath(prop.getProperty("Search.CloseGroup.Xpath"));
	return this;
}

	public SearchPage verifyFirstConnectionCount(){
	
		verifyResultCount(prop.getProperty("Search.Result.Id"), prop.getProperty("Search.Verify.Xpath"));
		return this;
	}
	
}


