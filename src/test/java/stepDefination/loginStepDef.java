package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;

public class loginStepDef {
	
	private WebDriver driver;
	private loginPage loginPage;
	
	@Before
	public void setup() {
		driver =new ChromeDriver();
		
	}
	
	@After
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	@Given("I am on the Saleforce login page")
		public void I_am_on_the_Saleforce_login_page() {
		driver.get("Url");
		loginPage = new loginPage(driver);
	}
	
	@Given("I have entered a valid Username and password")
		public void I_have_entered_a_valid_Username_and_password() {
		loginPage.enterUserNamel("input_Username");
		loginPage.enterPassword("input_password");
	}
	
	@Given("I have entered an invalid {string} and {string}")
		public void i_have_entered_invalid_and(String UserName, String Password) {
		loginPage.enterUserNamel(UserName);
		loginPage.enterPassword(Password);
	}
	
	@When("I click on the login button")
		public void I_click_on_the_login_button() {
		loginPage.clickLoginButton();
	}
	 @When("I click on the \"Forgotten password\" Link")
	 	public void I_click_on_the_Forgotten_password_Link() {
		 loginPage.clickForgottenPassword();
	 }
	 
	 @Then("I should be logged in successfully")
	 	public void I_should_be_logged_in_successfully() {
		 Assert.assertTrue(loginPage.verifyLoginpage());
	 }
	 
	 @Then("I should see an error message indicated \"invalid username or password\"")
	 	public void I_should_see_an_error_message() {
		 Assert.assertEquals(driver.findElement(By.id("error")).getText(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	 }
	 
	 @Then("I should be redirected to the password reset page")
	 	public void i_should_be_redirected() {
		 loginPage.getForgetPasswordUrl();
	 }
}
