package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class SecondCompanyPage extends LinkedInWrappers{

	public SecondCompanyPage(){
		
		if(!verifyTitleContains("LinkedIn")){

			Reporter.reportStep("The title did not match", "FAIL");
		}	
	}
	
	public SecondCompanyPage printEmployeesCount() {

		printEmployeesCountByClassName(prop.getProperty("SecondCompany.EmployeeCount.ClassName"));
		return this;
	}
	
}


