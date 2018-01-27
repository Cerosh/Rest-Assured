package POWithPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage {
	WebDriver driver;
	private final String URL = "https://vpl.bibliocommons.com/search";

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public Paging paging() {
		return new Paging(driver);
	}

	public TotalResultsPage totalResultsPage() {
		return new TotalResultsPage(driver);
	}

	public boolean isOpen() {
		return driver.getCurrentUrl().contains(URL);
	}

	public int pageNumber() {
		String url = driver.getCurrentUrl();
		int i1 = url.indexOf("page=") + "page=".length();
		int i2 = url.indexOf("&q=");
		return Integer.parseInt(url.substring(i1, i2));
	}
}
