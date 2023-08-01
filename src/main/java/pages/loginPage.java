package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	private WebDriver driver;

	// Locators
	private By UsernameInputLocator = By.id("username");
	private By passwordInputLocator = By.name("pw");
	private By profileButtonLocator = By.xpath("//span[@id='userNavLabel']");
	private By loginButtonLocator = By.xpath("//input[@id='Login']");
	private By forgettenPasswordLinkLocator = By.linkText("Forgot Your Password?");
	private By logoutLinkLocator = By.linkText("Log Out");
	private By verifyLoginpageLocator = By.id("phHeaderLogoImage");

	// constructor

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page Methods/Actions
	public void enterUserNamel(String UserName) {
		WebElement UserNme = driver.findElement(UsernameInputLocator);
		UserNme.sendKeys(UserName);
	}

	public void enterPassword(String Password) {
		WebElement password = driver.findElement(passwordInputLocator);
		password.sendKeys(Password);
	}

	public void clickLoginButton() {
		WebElement loginButton = driver.findElement(loginButtonLocator);
		loginButton.click();
	}

	public void clickProfileButton() {
		WebElement profile = driver.findElement(profileButtonLocator);
		profile.click();
	}

	public void clickForgottenPassword() {
		WebElement forgottenpass = driver.findElement(forgettenPasswordLinkLocator);
		forgottenpass.click();
	}

	public void clickLogout() {
		WebElement logout = driver.findElement(logoutLinkLocator);
		logout.click();
	}
	
	public boolean verifyLoginpage() {
		driver.findElement(verifyLoginpageLocator);
		return true;
	
	}
	
	public String getForgetPasswordUrl() {
		String forgetPasswordUrl = driver.getCurrentUrl();
		return forgetPasswordUrl;
				
	}
}
