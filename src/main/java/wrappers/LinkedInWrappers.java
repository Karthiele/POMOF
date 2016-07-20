package wrappers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;
import utils.Reporter;

public class LinkedInWrappers extends GenericWrappers {

	protected String browserName;
	protected String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;

	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException {
		Reporter.startResult();
		loadObjects();
	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.startTestCase();
		invokeApp(browserName);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.endResult();
	}

	@AfterTest
	public void afterTest() {

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		quitBrowser();
	}

	@DataProvider(name = "fetchData")
	public Object[][] getData() {
		return DataInputProvider.getSheet(dataSheetName);
	}

	public String resultCountById(String idVal) {
		// Print the number of search results
		String noOfResults = getTextById(idVal);

		String searchResultCount = split(noOfResults);
		Reporter.reportStep("Total No of Search Results: " + searchResultCount, "PASS");
		return searchResultCount;
	}

	public String split(String result) {

		// Taking only numeric value
		if (result.contains(",")){
	
		String[] resultSplit1 = result.split(" ");
		return resultSplit1[0].replace(",", "");
		}
		else{
			
			String[] resultSplit = result.split(" ");
			return resultSplit[0];
		}
	}
	
	public void printConnectionByXpath(String xPath){
		
		Reporter.reportStep("Displayed Connection Name: " + getTextByXpath(xPath), "PASS");
		
	}
	
	public void printCompanyNameByXpath(String xPath){
		
		Reporter.reportStep("Company Name is: " + getTextByXpath(xPath), "PASS");
		
	}
	
	public void printEmployeesCountByClassName(String className){
		
		Reporter.reportStep("Employees Count is: " + getTextByClassName(className), "PASS");
		
	}
	
	public void verifyConnectionTypeByXpath (String xpath){
		
		//Print if it is either 1st or 2nd connection
		String connectionType = getTextByXpath(xpath);
		
		if (connectionType.contains("1st"))
		{
		Reporter.reportStep("It is a First Connection", "INFO");
		}
		else if (connectionType.contains("2nd"))
		{
			Reporter.reportStep("It is a Second Connection", "INFO");
		}else
		{
			Reporter.reportStep("It is neither First nor Second Connection", "INFO");
		}
	}
	
	public void verifyResultCount(String idVal, String xPath){
		
		String resultCount = resultCountById(idVal);
		
		//verify Connection Count
		String searchResult = getTextByXpath(xPath);
		Reporter.reportStep("Search Result Count: " +searchResult, "INFO");
		
		if (searchResult.contains(resultCount))
		{
			Reporter.reportStep("Search Result Count: " +searchResult +" equals Result Count: " +resultCount, "PASS");
		}
		else
		{
			Reporter.reportStep("Search Result Count: " +searchResult +" not equals Result Count: " +resultCount, "WARN");
		}
	}
	
	public void verifySkill(String availSkill, String addSkill) throws InterruptedException{
		
		String availableSkills = getTextById(availSkill);
		
		if(availableSkills.contains(addSkill))
		{
			Reporter.reportStep("Given Skill " +addSkill +" is already added", "INFO");
		}
		else{
			
			addSkill(addSkill);
		}
	}
	
	public void addSkill(String addSkill) throws InterruptedException{
		
		//Click Add Skill
		clickByXpath("(//button[@title='Add skill'])[2]");
		Thread.sleep(4000);
		
		//Enter a new skill
		enterById("edit-skills-add-ta", addSkill);
		Thread.sleep(4000);
		
		//Click Add
		clickById("edit-skills-add-btn");
		Thread.sleep(4000);
		
		//Click Save
		clickByXpath("//input[@value='Save']");
		Thread.sleep(4000);
		
		Reporter.reportStep("Given Skill " +addSkill +" is added successfully", "PASS");
	}
	
	public void verifyViewButtonColor(String xPath, String attribute){
		
		String viewButtonColor = getCSSValueByXPath(xPath, attribute);
		
		if (viewButtonColor.equals("rgba(0,0,255,1)"))
		{
			Reporter.reportStep("Color of the view button is blue", "PASS");
		}
		else
		{
			Reporter.reportStep("Color of the View button is not BLUE", "INFO");
		}
	}
}
