package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestNgBase{

	@Test
	public void verifyAddNews() throws IOException {
		LoginPage loginPage= new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnSigninButton();
		
		NewsPage newsPage = new NewsPage(driver);
		boolean isAlertDisplayed = newsPage.addNews();
		Assert.assertTrue(isAlertDisplayed, "Alert is not displayed for adding news");
	}
	
	@Test
	public void verifyReset() throws IOException {
		LoginPage loginPage= new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnSigninButton();
		
		NewsPage newsPage = new NewsPage(driver);
		boolean isVisible = newsPage.resetPage();
		Assert.assertTrue(isVisible,"Reset is not visible");
		
	}
	
	@Test
	public void verifySearchNews() throws IOException {
		LoginPage loginPage= new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage.enterUserNameOnUsernameField(usernameValue);
		loginPage.enterPasswordOnPasswordField(passwordValue);
		loginPage.clickOnSigninButton();
		
		NewsPage newsPage = new NewsPage(driver);
		//boolean isVisible = newsPage.isSearchButtonVisible();
		boolean isDisplayed = newsPage.searchNews();
		Assert.assertTrue(isDisplayed, "Search button is not visible");
		
	}
	
	
	
}
