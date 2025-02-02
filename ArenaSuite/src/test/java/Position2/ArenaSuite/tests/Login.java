package Position2.ArenaSuite.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Position2.ArenaSuite.testcomponents.BaseTest;
import position2.arenasuite.pageobjects.LoginPage;

public class Login extends BaseTest {

	LoginPage loginpage;

	@BeforeClass
	public void setup() throws IOException {
		initializeDriver();
		launchApplication();
		loginpage = new LoginPage(driver);

	}

	// Test case for Login to Arena with Valid username and Invalid password
	@Test(priority = 1)
	public void inValidLogin() throws InterruptedException {
		loginpage.inValidLogin();
		String errorMessage = loginpage.getLoginErrorMessage();
		Assert.assertEquals(errorMessage, "Password doesnot match for the email id given",
				"Error message does not match");

	}

	// Test case for Login to Arena with Valid username and password
	@Test(priority = 2)
	public void validLogin() {
		loginpage.loginArenaValid();

	}
	
	
	
	

}
