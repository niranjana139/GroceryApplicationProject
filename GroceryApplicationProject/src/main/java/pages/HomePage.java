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
	@FindBy(xpath = "//a[contains(@class, 'small-box-footer') and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement tile;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement arrow;
	public void clickOnAdminIcon() {
		utility.clickOnElement(admin);
	}
	public LoginPage checkLogout() {
		utility.clickOnElement(logout);
		return new LoginPage(driver);
	}
	public boolean isLogoutDisplayed() {
		return logout.isDisplayed();
	}
	public AdminPage clickOnTile() {
		utility.clickOnElement(tile);
		return new AdminPage(driver);
	}
	
	public AdminPage clickOnNewsTile() {
		utility.clickOnElement(arrow);
		return new AdminPage(driver);
	}
	
}
