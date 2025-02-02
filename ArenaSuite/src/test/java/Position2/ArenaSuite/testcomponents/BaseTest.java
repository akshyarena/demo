package Position2.ArenaSuite.testcomponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import position2.arenasuite.pageobjects.LoginPage;

public class BaseTest {
	public static WebDriver driver;
	public LoginPage loginpage;

	@BeforeSuite
	public void initializeDriver() {

		if (driver == null) {
		//	ChromeOptions options = new ChromeOptions();
	     //   options.addArguments("--headless"); // Enable headless mode
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}
		clearScreenshots();
	}

	public LoginPage launchApplication() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.goTo();
		return loginpage;
	}
	
	//Method to take screenshot
	public String getScreenshot(String testCaseName) throws IOException
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File source= screenshot.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+"//screenshot//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//screenshot//" + testCaseName + ".png";
	}
	
	
	
	
	
	
	
	//Method to clear the existing screenshot
	 public void clearScreenshots() {
	        File screenshotDir = new File(System.getProperty("user.dir") + "//screenshot");
	        if (screenshotDir.exists()) {
	            try {
	                FileUtils.cleanDirectory(screenshotDir);
	                
	            } catch (IOException e) {
	                System.err.println("Failed to clear screenshot directory: " + e.getMessage());
	            }
	        }
	    }
	
	
	
	
	
	
	
	
	

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
