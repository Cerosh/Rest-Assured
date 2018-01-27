package POWithReturnPageObject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
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

	@Test(priority = 1)
	public void searchReturnResults() {
		HomePage homePage = new HomePage(driver);
		homePage.open();
		ResultsPage resultsPage =homePage.searchFor("Java");
		assertTrue(resultsPage.isOpen() == true);
		assertTrue(resultsPage.count() > 0);
	}
	@Test(priority = 2)
	public void goToPage() {
		HomePage homePage = new HomePage(driver);
		homePage.open();
		ResultsPage resultsPage =homePage.searchFor("Java");
		ResultsPage goToPage = resultsPage.goTo(5);
		assertTrue(goToPage.pageNumber()==5);
	}
	
	@Test(priority = 3)
		public void goToNext() {
			HomePage homePage = new HomePage(driver);
			homePage.open();
			ResultsPage resultsPage =homePage.searchFor("Java");
			ResultsPage goToPage = resultsPage.goToNextPage();
			assertTrue(goToPage.pageNumber()==2);
		}
	@Test(priority = 4)
	public void goToPrevious() {
		HomePage homePage = new HomePage(driver);
		homePage.open();
		ResultsPage resultsPage =homePage.searchFor("Java");
		ResultsPage result3 = resultsPage.goTo(3);
		ResultsPage goToPrevious = resultsPage.goToPrevPage();
		assertTrue(goToPrevious.pageNumber()==2);
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
