package position2.arenasuite.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import position2.arenasuite.reusablecomponent.ReusableComponent;

public class LoginPage extends ReusableComponent {
	WebDriver driver;

	public LoginPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement userLoginEmail;

	@FindBy(id = "password")
	WebElement userLoginPassword;

	@FindBy(xpath = "//button[contains(@class,'bt-theme-primary')]")
	WebElement loginSubmitButton;

	@FindBy(xpath = "//p[@class='sc-gLQOX fycyuQ']")
	WebElement passwordMismatch;

	public void goTo() {
		driver.get("https://test.thearena.ai/");
	}

	public void inValidLogin() throws InterruptedException {

		String email1 = getProperty("validUsername");
		String password2 = getProperty("inValidPassword");
		userLoginEmail.clear();
		userLoginEmail.sendKeys(email1);
		userLoginPassword.clear();
		userLoginPassword.sendKeys(password2);
		loginSubmitButton.click();

	}

	public String getLoginErrorMessage() {
		waitForElementToBeClickable(passwordMismatch);
		return passwordMismatch.getText();
	}

	public void loginArenaValid() {

		String email1 = getProperty("validUsername");
		String password1 = getProperty("validPassword");
		userLoginEmail.clear();
		userLoginEmail.sendKeys(email1);
		userLoginPassword.clear();
		userLoginPassword.sendKeys(password1);
		loginSubmitButton.click();
	}

}
