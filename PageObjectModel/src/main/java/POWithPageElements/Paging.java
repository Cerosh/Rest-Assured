package POWithPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Paging {
	WebDriver driver;
	private final By NXT_PAGE = By.xpath("//a[@testid='link_nextpage']");
	private final By PRVS_PAGE = By.xpath("//a[@testid='link_prevpage']");

	public Paging(WebDriver driver) {
		this.driver = driver;
	}

	private By pageSelector(int n) {
		String locator = "//a[@testid='link_page%d']";
		locator = locator.format(locator, n);
		return By.xpath(locator);
	}

	public ResultsPage goToPage(int i) {
		driver.findElement(pageSelector(i)).click();
		return new ResultsPage(driver);
	}

	public ResultsPage goToNextPage() {
		WebElement nextPage = driver.findElement(NXT_PAGE);
		nextPage.click();
		return new ResultsPage(driver);
	}

	public ResultsPage goToPrvsPage() {
		driver.findElement(PRVS_PAGE).click();
		return new ResultsPage(driver);
	}

}
