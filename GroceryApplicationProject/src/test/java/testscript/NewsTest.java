package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestNgBase{
	HomePage home;
	@Test(description = "Verify if the news is added")
	public void verifyAddNews() throws IOException {
		LoginPage loginPage= new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		loginPage.enterUserNameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home=loginPage.clickOnSigninButton();
		
		NewsPage newsPage = new NewsPage(driver);
		home.clickOnNewsTile();
		newsPage.clickNewButton().addNews().saveNews();
		
		//newsPage.addNews();
		boolean isAlertDisplayed = newsPage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Messages.ADD_NEWS_ERROR);
	}
	
	@Test(description = "Verify if the reset functionality is working in news page")
	public void verifyReset() throws IOException {
		LoginPage loginPage= new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		loginPage.enterUserNameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home=loginPage.clickOnSigninButton();
		
		NewsPage newsPage = new NewsPage(driver);
		//newsPage.clickTile();
		//boolean isVisible = newsPage.isResetButtonDisplayed();
		home.clickOnNewsTile();
		newsPage.resetPage();
		String expected="https://groceryapp.uniqassosiates.com/admin/list-news";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,expected,Messages.RESET_NEWS_ERROR);
		
	}
	
	@Test(description = "Verify if a given news is able to be searched")
	public void verifySearchNews() throws IOException {
		LoginPage loginPage= new LoginPage(driver);
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		loginPage.enterUserNameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		home=loginPage.clickOnSigninButton();
		
		NewsPage newsPage = new NewsPage(driver);
		
		home.clickOnNewsTile();
		newsPage.clickSearchNewsButton().addSearchingNews().clickSearch();
		boolean isSearchNewsButtonDisplayed = newsPage.isSearchButtonDisplayed();
		Assert.assertTrue(isSearchNewsButtonDisplayed, Messages.SEARCH_NEWS_ERROR);
		/*
		 * String expected="https://groceryapp.uniqassosiates.com/admin"; String
		 * actual=driver.getCurrentUrl(); Assert.assertEquals(actual.contains(expected),
		 * Messages.SEARCH_NEWS_ERROR);
		 */
	}
	
	
	
}
