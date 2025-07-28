package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[contains(@src, 'avatar5.png')]")WebElement admin;
	@FindBy(css = "a i.fa-power-off")WebElement logout;
	public boolean performLogout() {
		admin.click();
		boolean isLogoutDisplayed = logout.isDisplayed();
		logout.click();
		return isLogoutDisplayed;
	}
}
