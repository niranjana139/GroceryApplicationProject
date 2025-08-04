package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
import constant.Messages;
import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNgBase{
	
	@Test
	public void verifyUserAbleToAddUser() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnSigninButton();
		AdminPage admin= new AdminPage(driver);
		//admin.clickOnTile();
		//admin.clickOnNew();
		FakerUtility fakerUtility = new FakerUtility();
		String name=fakerUtility.createRandomUserName();
		String password=fakerUtility.createRandomPassword();
		String userType=ExcelUtility.getStringData(1, 2, "HomePage");
		admin.addDataAndClickSave(name, password,userType);
		String expected="https://groceryapp.uniqassosiates.com/admin/list-admin?add";
		String actual = driver.getCurrentUrl();
		System.out.println(actual);
		Assert.assertTrue(actual.contains(expected),Messages.USERADD_ERROR);
	}
	
	@Test
	public void verifySearch() throws IOException{
		LoginPage loginPage = new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnSigninButton();
		AdminPage admin= new AdminPage(driver);
		FakerUtility fakerUtility = new FakerUtility();
		String name=fakerUtility.createRandomUserName();
		String userType=ExcelUtility.getStringData(1, 2, "HomePage");

		
		admin.searchUser(name, userType);
		boolean isSearchDisplayed = admin.isSearchButtonDisplayed();
		Assert.assertTrue(isSearchDisplayed,Messages.SEARCH_USER_ERROR);
	}
	
	@Test
	public void verifyReset() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnSigninButton();
		
		AdminPage admin=new AdminPage(driver);
		admin.reset();
		String expected = driver.getCurrentUrl();
		String actual="https://groceryapp.uniqassosiates.com/admin/list-admin";
		Assert.assertEquals(actual, expected,Messages.RESET_ERROR);
			
	}

}
