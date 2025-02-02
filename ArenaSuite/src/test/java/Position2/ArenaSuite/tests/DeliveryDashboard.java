package Position2.ArenaSuite.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Position2.ArenaSuite.testcomponents.BaseTest;
import position2.arenasuite.pageobjects.DeliveryDashboardPage;

public class DeliveryDashboard extends BaseTest {
	// WebDriver driver;
	DeliveryDashboardPage deliveryDashboardPage;

	@BeforeClass
	public void setup() throws IOException {

		deliveryDashboardPage = new DeliveryDashboardPage(driver);
	}

	// Validating the page after successful login like assertion checks
	@Test(dependsOnMethods = "Position2.ArenaSuite.tests.Login.validLogin")
	public void assertionCheck() {
		String expectedSubstring = "https://test.thearena.ai/";
		deliveryDashboardPage.verifyElementsPresentOnDashboard();
		deliveryDashboardPage.verifyUrl(expectedSubstring);

	}

	// Saving a filter and checking whether the filter has been created successfully
	@Test(dependsOnMethods = "assertionCheck")
	public void saveFilterCreation() throws InterruptedException {
		deliveryDashboardPage.createAndSaveFilter("Magnum (CreditStrong)", "Filtername 1");
		deliveryDashboardPage.verifyFilterPresent("Filtername 1");

	}

	@Test(dependsOnMethods = "saveFilterCreation")
	public void addTimeEntry() throws InterruptedException {
		deliveryDashboardPage.addTimeEntry("002Notification:");

	}

}
