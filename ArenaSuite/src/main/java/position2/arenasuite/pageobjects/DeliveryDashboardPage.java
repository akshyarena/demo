package position2.arenasuite.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import position2.arenasuite.reusablecomponent.ReusableComponent;

public class DeliveryDashboardPage extends ReusableComponent {

	WebDriver driver;

	public DeliveryDashboardPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[contains(text(),'Create Task')]")
	WebElement createTask;

	@FindBy(xpath = "//div[@data-tooltip-id='filter-icon']")
	WebElement filterIconVisible;

	@FindBy(xpath = "//input[@aria-label='Search Tasks']")
	WebElement searchArea;

	@FindBy(xpath = "//h4[@aria-label='Time Entry ']")
	WebElement timeEntry;

	@FindBy(xpath = "//div[@data-tooltip-id='filter-icon']")
	WebElement filterIcon;

	@FindBy(id = "account")
	WebElement accountInput;

	@FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option']")
	WebElement accountOption;

	@FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option']")
	List<WebElement> accountOptions;

	@FindBy(xpath = "//span[contains(text(),'Save Filter')]")
	WebElement saveFilterButton;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement filterNameInput;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement finalSaveButton;

	@FindBy(id = "closeFilter")
	WebElement closeFilterButton;

	@FindBy(xpath = "//h4[contains(@class, 'cursor-pointer')]")
	List<WebElement> filterList;

	@FindBy(xpath = "//h4[normalize-space()='Time Entry']")
	WebElement timeEntryAdd;

	@FindBy(xpath = "//input[@id='rc_select_13']")
	WebElement taskSelectSearch;

	@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
	WebElement taskListOption;

	@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
	List<WebElement> taskListOptions;

	public void verifyElementsPresentOnDashboard() {
		Assert.assertTrue(createTask.isDisplayed(), "Create Task is not present on the page.");
		Assert.assertTrue(filterIcon.isDisplayed(), "Filter icon is not present on the page.");
		Assert.assertTrue(searchArea.isDisplayed(), "Search Area section is not present on the page.");
		Assert.assertTrue(timeEntry.isDisplayed(), "Time entry CTA is present on the page.");
	}

	public void verifyUrl(String expectedSubstring) {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains(expectedSubstring), "URL does not contain the expected substring.");
	}

	public void createAndSaveFilter(String accountName, String filterName) throws InterruptedException {
		waitForElementToBeClickable(filterIcon);
		clickElement(filterIcon);
		Thread.sleep(3000);
		// waitForElementToBeClickable(accountInput);
		accountInput.sendKeys("Credit");
		waitForElementToBeClickable(accountOption);
		for (WebElement option : accountOptions) {
			if (option.getText().equalsIgnoreCase(accountName)) {
				option.click();
				break;
			}
		}
		clickElement(saveFilterButton);
		waitForElementToBeClickable(filterNameInput).sendKeys(filterName);
		clickElement(finalSaveButton);
		clickElement(closeFilterButton);

	}

	public void verifyFilterPresent(String filterName) {
		boolean filterFound = false;
		for (WebElement filterListOptions : filterList) {
			if (filterListOptions.getText().equalsIgnoreCase(filterName)) {
				filterFound = true;
				break;
			}
		}
		Assert.assertTrue(filterFound, filterName + " was not found in the filter list.");

	}

	public void addTimeEntry(String taskTitle) throws InterruptedException {
		clickElement(timeEntryAdd);
		waitForElementToBeClickable(taskSelectSearch);
		taskSelectSearch.sendKeys("002");
		//Thread.sleep(3000);
		// waitForElementsToAppear(taskListOption);

		for (WebElement option : taskListOptions) {
			if (option.getText().contains(taskTitle)) {
				waitForElementToBeClickable(option);
				clickElement(option);
				//option.click();

				break;
			}

		}

	}

}
