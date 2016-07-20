package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class ProfilePage extends LinkedInWrappers{

	public ProfilePage(){
		
		if(!verifyTitle("Edit Profile | LinkedIn")){

			Reporter.reportStep("The title did not match", "FAIL");
		}
	}
	
	public ProfilePage verifyCurrentOrganization(String orgName) {

		verifyTextContainsByXpath(prop.getProperty("Profile.Organization.Xpath"), orgName);
		return this;
	}
	
	public ProfilePage verifyAndAddSkill(String skill) throws InterruptedException {

		verifySkill(prop.getProperty("Profile.VerifySkill.Id"), skill);
		return this;
	}
	
	public ProfilePage verifyAddedSkill(String skill) throws InterruptedException {

		verifySkill(prop.getProperty("Profile.VerifySkill.Id"), skill);
		return this;
	}
}


