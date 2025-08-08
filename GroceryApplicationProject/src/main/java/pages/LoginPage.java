package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	PageUtility utility = new PageUtility();
	WaitUtility waitUtility = new WaitUtility();
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@FindBy(name="username")WebElement username;
	public LoginPage enterUserNameOnUsernameField(String usernameValue) {
		username.sendKeys(usernameValue);
		return this;
	}
	
	@FindBy(name="password")WebElement password;
	public LoginPage enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
		return this;
	}
	
	@FindBy(css = "button[class=\"btn btn-dark btn-block\"]")WebElement signin;
	public HomePage clickOnSigninButton() {
		signin.click();
		return new HomePage(driver);
	}
	
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dash;
	public boolean isDashboardDisplayed() {
		waitUtility.waitUntilElementIsVisible(driver, dash);
		return dash.isDisplayed();
	}
	
	public void performLogin(String usernameValue,String passwordValue) {
		utility.sendDataToElement(username, usernameValue);
		utility.sendDataToElement(password, passwordValue);
		utility.clickOnElement(signin);
	}

	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement title;
	public String titleText() {
		return title.getText();
	}
	
}
