package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
	WaitUtility waitUtility = new WaitUtility();
	public WebDriver driver;
	PageUtility pageUtility = new PageUtility();
	
	public AdminPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@FindBy(xpath = "//a[contains(@class, 'small-box-footer') and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement tile;

	
	@FindBy(xpath="//a[@class=\"btn btn-rounded btn-danger\"]")WebElement newButton;
	@FindBy(id = "username")WebElement addName;
	@FindBy(id="password")WebElement addPassword;
	@FindBy(xpath= "//select[@name='ut']")WebElement userType;
	@FindBy(xpath = "//button[@name='Create']")WebElement saveBtn;
	@FindBy(xpath="//select[@name='user_type']")WebElement userTypes;
	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-primary\"]")WebElement search;
	@FindBy(id="un")WebElement username;
	@FindBy(id="ut")WebElement userTypeDrop;
	@FindBy(xpath = "//button[@name='Search']") WebElement searchBtn;
	
	 

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")WebElement resetBtn;
	
	public AdminPage clickNewButton() {
		pageUtility.clickOnElement(newButton);
		return new AdminPage(driver);
	}
	
	public AdminPage addName(String name) {
		pageUtility.sendDataToElement(addName, name);
		return new AdminPage(driver);
	}
	
	public AdminPage addPassword(String password) {
		pageUtility.sendDataToElement(addPassword, password);
		return new AdminPage(driver);
	}
	
	public AdminPage selectType(String userTypeValue) {
		pageUtility.selectDataWithValue(userTypes,userTypeValue);
		return new AdminPage(driver);
	}
	public AdminPage clickSave() {
		//pageUtility.clickOnElement(tile);
		//pageUtility.clickOnElement(newButton);
		//pageUtility.sendDataToElement(addName, name);
	
		//addName.sendKeys(name);
		//addPassword.sendKeys(password);
		
		pageUtility.clickOnElement(saveBtn);	
		return new AdminPage(driver);
	}
	
	public AdminPage clickSearch() {
		pageUtility.clickOnElement(search);
		return new AdminPage(driver);
	}
	
	public AdminPage searchUsername(String name) {
		pageUtility.sendDataToElement(username, name);
		return new AdminPage(driver);
	}
	
	public AdminPage searchUserType(String userTypeValue) {
		pageUtility.selectDataWithValue(userType, userTypeValue);
		return new AdminPage(driver);
	}
	public AdminPage searchUser() {
		//pageUtility.clickOnElement(tile);
		//pageUtility.clickOnElement(search);
		//search.click();
		//username.sendKeys(name);
		//pageUtility.sendDataToElement(username, name);
		//pageUtility.selectDataWithValue(userType, userTypeValue);
		waitUtility.waitUntilClickable(driver, searchBtn);
		pageUtility.clickOnElement(searchBtn);
		return new AdminPage(driver);
		//searchBtn.click();
	}
	
	public boolean isSearchButtonDisplayed() {
		return searchBtn.isDisplayed();
	}
	
	public boolean isResetButtonDisplayed() {
		return resetBtn.isDisplayed();
	}
	
	public AdminPage reset() {
		//pageUtility.clickOnElement(tile);
		pageUtility.clickOnElement(resetBtn);
		return new AdminPage(driver);
		
	}
	
}
