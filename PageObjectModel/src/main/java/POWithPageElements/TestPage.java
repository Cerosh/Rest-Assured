package POWithPageElements;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPage {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/ceroshjacob/Downloads/PageObjectModel/Browserdrivers/chromedriver");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void searchReturnsResults() {
		HomePage homepage = new HomePage(driver);
		homepage.open();
		ResultsPage rsltPage = homepage.searchFor("java");
		assertTrue(rsltPage.totalResultsPage().count() > 0);
		assertTrue(rsltPage.isOpen() == true);
	}

	@Test(priority = 2)
	public void goToPage() {
		HomePage homepage = new HomePage(driver);
		homepage.open();
		ResultsPage rsltPage = homepage.searchFor("selenium");
		ResultsPage goToPage = rsltPage.paging().goToPage(3);
		assertTrue(goToPage.pageNumber() == 3);
	}

	@Test(priority = 3)
	public void goToNextPage() {
		HomePage homepage = new HomePage(driver);
		homepage.open();
		ResultsPage rsltPage = homepage.searchFor("oracle");
		ResultsPage goToNextPage = rsltPage.paging().goToNextPage();
		assertTrue(goToNextPage.pageNumber() == 2);
	}

	@Test(priority = 4)
	public void goToPrvsPage() {
		HomePage homepage = new HomePage(driver);
		homepage.open();
		ResultsPage rsltPage = homepage.searchFor("computer");
		ResultsPage goToPage = rsltPage.paging().goToPage(3);
		ResultsPage goToPrvsPage = goToPage.paging().goToPrvsPage();
		assertTrue(goToPrvsPage.pageNumber() == 2);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		driver = null;
	}

}
