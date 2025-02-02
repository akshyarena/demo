package position2.arenasuite.reusablecomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponent {
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;

	public ReusableComponent(WebDriver driver) throws IOException {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			this.prop = loadProperties();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	protected WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected WebElement waitForElementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	protected WebElement waitForElementToAppear(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));

	}

	
	protected List<WebElement> waitForElementsToAppear(List<WebElement> element) {
		return wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}
	public void clickElement(WebElement element) {
		waitForElementToBeClickable(element).click();
	}

	public Properties loadProperties() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//position2//arenasuite//resources//GlobalData.properties");
		prop.load(fis);
		prop.getProperty("validUsername");
		prop.getProperty("validPassword");
		prop.getProperty("inValidUsername");
		prop.getProperty("inValidPassword");
		return prop;

	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	
	
	public File getScreenshot(String testCaseName) throws IOException
	{
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File imageLocatedfile= new File(System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(screenshotFile, imageLocatedfile);
		return imageLocatedfile;
	}

}
