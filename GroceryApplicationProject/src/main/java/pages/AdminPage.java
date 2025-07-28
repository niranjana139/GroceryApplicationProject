package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
	
	public WebDriver driver;
	
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
		tile.click();
		newButton.click();
		addName.sendKeys(name);
		addPassword.sendKeys(password);
		Select select = new Select(userType);
		select.selectByContainsVisibleText(userTypeValue);
		saveBtn.click();
		
	}

	
	/*
	 * @FindBy(xpath =
	 * "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']"
	 * )WebElement arrow;
	 * 
	 * @FindBy(xpath = "//a[@class=\"btn btn-rounded btn-primary\"]")WebElement
	 * search;
	 * 
	 * @FindBy(id="un")WebElement username;
	 * 
	 * @FindBy(id="ut")WebElement userTypeDrop;
	 * 
	 * @FindBy(xpath = "//button[@name=\"Search\"]") WebElement searchBtn;
	 */
	public boolean searchUser(String name,String userType) {
		tile.click();
		search.click();
		username.sendKeys(name);
		Select select =new Select(userTypeDrop);
		select.selectByContainsVisibleText(userType);
		boolean isSearchButtonDisplayed = searchBtn.isDisplayed();
		searchBtn.click();
		return isSearchButtonDisplayed;
	}
	
	public boolean reset() {
		tile.click();
		boolean isResetBtnDisplayed = resetBtn.isDisplayed();
		resetBtn.click();
		return isResetBtnDisplayed;
	}
	
	/*public String getAdminText() {
		return title.getText();
		
	}*/
}
