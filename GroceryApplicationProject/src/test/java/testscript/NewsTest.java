package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
import constant.Messages;
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
		newsPage.addNews();
		boolean isAlertDisplayed = newsPage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Messages.ADD_NEWS_ERROR);
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
		//newsPage.clickTile();
		//boolean isVisible = newsPage.isResetButtonDisplayed();
		newsPage.resetPage();
		String expected="https://groceryapp.uniqassosiates.com/admin/list-news";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,expected,Messages.RESET_NEWS_ERROR);
		
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
		
		
		newsPage.searchNews();
		String expected="https://groceryapp.uniqassosiates.com/admin/list-news";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,expected,Messages.SEARCH_NEWS_ERROR);
		
	}
	
	
	
}
