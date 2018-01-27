package withPageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tests {
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/ceroshjacob/Downloads/PageObjectModel/Browserdrivers/chromedriver");
		driver = new ChromeDriver();
	}

	@Test
	public void searchReturnsResults() {
		HomePage homePage = new HomePage(driver);
		homePage.open();
		homePage.searchFor("Selenium");
		ResultsPage resultsPage = new ResultsPage(driver);
		assertTrue(resultsPage.isOpen() == true);
		assertTrue(resultsPage.count() > 0);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
