package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
import constant.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNgBase{
	HomePage homePage;
	
	@Test(description = "Verify if a user is able to be added")
	public void verifyUserAbleToAddUser() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=loginPage.clickOnSigninButton();
		AdminPage admin= new AdminPage(driver);
		//admin.clickOnTile();
		//admin.clickOnNew();
		FakerUtility fakerUtility = new FakerUtility();
		String name=fakerUtility.createRandomUserName();
		String password=fakerUtility.createRandomPassword();
		String userType=ExcelUtility.getStringData(1, 2, "HomePage");
		//admin.addDataAndClickSave(name, password,userType);
		homePage.clickOnTile();
		admin.clickNewButton().addName(name).addPassword(password).selectType(userType).clickSave();
		
		/*
		 * String expected="https://groceryapp.uniqassosiates.com/admin/list-admin?add";
		 * String actual = driver.getCurrentUrl(); System.out.println(actual);
		 * Assert.assertTrue(actual.contains(expected),Messages.USERADD_ERROR);
		 */
	}
	
	@Test(description = "Verify if a user can be searched")
	public void verifySearch() throws IOException{
		LoginPage loginPage = new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=loginPage.clickOnSigninButton();

		//loginPage.performLogin(usernameValue, passwordValue);
		AdminPage admin= new AdminPage(driver);
		FakerUtility fakerUtility = new FakerUtility();
		String name=fakerUtility.createRandomUserName();
		String userType=ExcelUtility.getStringData(1, 2, "HomePage");
		homePage.clickOnTile();
		admin.clickSearch().searchUsername(name).searchUserType(userType).searchUser();
		//admin.searchUser(name, userType);
		boolean isSearchButtonDisplayed = admin.isSearchButtonDisplayed();
		Assert.assertTrue(isSearchButtonDisplayed, Messages.SEARCH_USER_ERROR);
		//Assert.assertTrue(false);
	}
	@Test(description = "Verify if the reset functionality is working in admin page")
	public void verifyReset() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=loginPage.clickOnSigninButton();

		
		AdminPage admin=new AdminPage(driver);
		homePage.clickOnTile();
		admin.reset();
		String expected = driver.getCurrentUrl();
		String actual="https://groceryapp.uniqassosiates.com/admin/list-admin";
		Assert.assertEquals(actual, expected,Messages.RESET_ERROR);
			
	}

}
