package pages;

import utils.Reporter;
import wrappers.LinkedInWrappers;

public class LoginPage extends LinkedInWrappers{

	public LoginPage(){
		
		if(!verifyTitle("World’s Largest Professional Network | LinkedIn")){

			Reporter.reportStep("The title did not match", "FAIL");
		}
	}
	
	public LoginPage enterUserName(String userName){
		
		enterById(prop.getProperty("Login.UserName.Id"), userName);
		return this;
	}
	
	public LoginPage enterPassword(String passWord){
		
		enterById(prop.getProperty("Login.Password.Id"), passWord);
		return this;
	}
	
	public HomePage clickSignIn(){
		
		clickByName(prop.getProperty("Login.LoginButton.Name"));
		return new HomePage();
	}
	
}
