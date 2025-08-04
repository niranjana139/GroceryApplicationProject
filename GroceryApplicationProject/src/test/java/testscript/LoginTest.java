package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
import constant.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNgBase {
	
	@Test(priority = 1,description = "Verify User login with valid credentials",retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserIsAbleToLoginWithValidCredential() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnSigninButton();
		boolean dashBoardDisplay =loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashBoardDisplay,Messages.VALID_CREDENTIAL_ERROR);
	}

	
	@Test(priority = 2)
	public void verifyWhetherUserIsAbleToLoginWithValidPasswordInvalidUsername() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(2, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnSigninButton();
		String expected = "7rmart supermarket";
		String actual = loginPage.titleText();
		Assert.assertEquals(actual, expected,Messages.INVALID_CREDENTIAL_USERNAME_ERROR);
		
	}

	@Test(priority = 3)
	public void verifyWhetherUserIsAbleToLoginWithInValidPasswordValidUsername() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(3, 1, "LoginPage");
		System.out.println(usernameValue);
		System.out.println(passwordValue);
		loginPage.enterUserNameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnSigninButton();
		String expected = "7rmart supermarket";
		String actual = loginPage.titleText();
		Assert.assertEquals(actual, expected,Messages.INVALID_CREDENTIAL_PASSWORD_ERROR);
	}
	@Test(priority = 4)
	public void verifyWhetherUserIsAbleToLoginWithInValidPasswordInValidUsername() throws IOException{
		LoginPage loginPage = new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(4, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(4, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnSigninButton();
		String expected = "7rmart supermarket";
		String actual = loginPage.titleText();
		Assert.assertEquals(actual, expected,Messages.INVALID_CREDENTIALS_ERROR);
	}
}
