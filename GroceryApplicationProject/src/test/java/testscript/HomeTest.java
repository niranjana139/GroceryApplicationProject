package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class HomeTest extends TestNgBase{
	
	@Test
	public void verifyWhetherUserAbleToLogout() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnSigninButton();
		
		  HomePage homePage=new HomePage(driver);
		  
		  String actual="https://groceryapp.uniqassosiates.com/admin/login";
		  homePage.checkLogout();
		  String expected=driver.getCurrentUrl();
		  Assert.assertEquals(actual, expected,Messages.LOGOUT_ERROR);
		 
	}

	
}
