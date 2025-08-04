package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(name="username")WebElement username;
	public void enterUserNameOnUsernameField(String usernameValue) {
		username.sendKeys(usernameValue);
	}
	
	@FindBy(name="password")WebElement password;
	public void enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
	}
	
	@FindBy(css = "button[class=\"btn btn-dark btn-block\"]")WebElement signin;
	public void clickOnSigninButton() {
		signin.click();
	}
	
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dash;
	public boolean isDashboardDisplayed() {
		return dash.isDisplayed();
	}

	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement title;
	public String titleText() {
		return title.getText();
	}
}
