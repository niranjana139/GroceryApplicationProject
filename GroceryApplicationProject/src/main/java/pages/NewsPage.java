package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;

public class NewsPage {
	
	public WebDriver driver;
	
	public  NewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement arrow;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")WebElement newBtn;
	@FindBy(id = "news")WebElement newsText;
	@FindBy(xpath = "//button[@name='create']")WebElement saveBtn;
	@FindBy(xpath = "//a[text()='Cancel']")WebElement cancel;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")WebElement searchBtn;
	@FindBy(xpath = "//input[@placeholder='Title']")WebElement titleSearch;
	@FindBy(xpath = "//button[@name='Search']")WebElement searchNews;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") WebElement resetBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	@FindBy(xpath="//h4[text()='Manage News']")WebElement manage;
	@FindBy(xpath = "//h4[text()='Search Manage News']")WebElement searchManageNews;
	
	public void addNews() {
		arrow.click();
		newBtn.click();
		newsText.sendKeys(Constants.NEWSTEXT);
		saveBtn.click();
		
	}
	
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
	
	public void clickTile() {
		arrow.click();
	}
	public void resetPage() {
		resetBtn.click();
	}
	
	public boolean isResetButtonDisplayed() {
		return resetBtn.isDisplayed();
	}
	
	public boolean isSearchButtonDisplayed() {
		return searchBtn.isDisplayed();
	}
	public void searchNews() {
		searchBtn.click();
		titleSearch.sendKeys(Constants.NEWSTEXT);
		searchNews.click();
	}
	
	public boolean isManageNewsVisible() {
		return manage.isDisplayed();
	}
	
	public boolean isSearchButtonVisible() {
		return searchBtn.isDisplayed();
	}

}
