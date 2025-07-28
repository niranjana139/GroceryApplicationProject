package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
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
		Assert.assertTrue(actual.contains(expected));
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
		boolean isSearchDisplayed = admin.searchUser(name, userType);
		Assert.assertTrue(isSearchDisplayed,"Search button is not displayed to perform search operation");
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
		boolean isResetDisplayed = admin.reset();
		Assert.assertTrue(isResetDisplayed,"Reset button is not displayed as expected");
			
	}

}
