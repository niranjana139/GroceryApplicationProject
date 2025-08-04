package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminPage {
	
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
	@FindBy(id= "user_type")WebElement userType;
	@FindBy(xpath = "//button[@name='Create']")WebElement saveBtn;
	
	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-primary\"]")WebElement search;
	@FindBy(id="un")WebElement username;
	@FindBy(id="ut")WebElement userTypeDrop;
	@FindBy(xpath = "//button[@name=\"Search\"]") WebElement searchBtn;
	
	
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")WebElement resetBtn;
	
	
	public void addDataAndClickSave(String name,String password,String userTypeValue) {
		pageUtility.clickOnElement(tile);
		pageUtility.clickOnElement(newButton);
		pageUtility.sendDataToElement(addName, name);
		pageUtility.sendDataToElement(addPassword, password);
		//addName.sendKeys(name);
		//addPassword.sendKeys(password);
		pageUtility.selectDataWithValue(userType,userTypeValue);
		pageUtility.clickOnElement(saveBtn);		
	}
	
	public boolean isSearchButtonDisplayed() {
		
		return searchBtn.isDisplayed();
	}


	
	
	public void searchUser(String name,String userType) {
		pageUtility.clickOnElement(tile);
		pageUtility.clickOnElement(search);
		//search.click();
		//username.sendKeys(name);
		pageUtility.sendDataToElement(username, name);
		pageUtility.selectDataWithValue(addName, userType);
		pageUtility.clickOnElement(searchBtn);
		//searchBtn.click();
	}
	
	
	public boolean isResetButtonDisplayed() {
		return resetBtn.isDisplayed();
	}
	
	public void reset() {
		pageUtility.clickOnElement(tile);
		pageUtility.clickOnElement(resetBtn);
		
	}
	
	/*public String getAdminText() {
		return title.getText();
		
	}*/
}
