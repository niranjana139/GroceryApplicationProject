package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	
	public WebDriver driver;
	PageUtility utility = new PageUtility();
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[contains(@src, 'avatar5.png')]")WebElement admin;
	@FindBy(css = "a i.fa-power-off")WebElement logout;
	
	public void checkLogout() {
		utility.clickOnElement(logout);
		utility.clickOnElement(admin);
		
	}
	public boolean isLogoutDisplayed() {
		return logout.isDisplayed();
	}
}
