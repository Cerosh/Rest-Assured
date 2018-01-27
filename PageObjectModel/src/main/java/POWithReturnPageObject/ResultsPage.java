package POWithReturnPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage {
WebDriver driver;
private   final String URL = "https://vpl.bibliocommons.com/search";
private String locator = "//a[@testid='link_page%d']";
private final By COUNT = 	By.xpath("//span[@class='items_showing_count']");
private final By NEXT = 		By.xpath("//a[@testid='link_nextpage']");
private final By PREVIOUS = 	By.xpath("//a[@testid='link_prevpage']");

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isOpen() {
		return driver.getCurrentUrl().contains(URL);
	}

	

	public int count() {
		WebElement label = driver.findElement(COUNT	);
		String text = label.getText();
		int i1 = text.indexOf("of")+3;
		int i2 = text.indexOf("items");
		return Integer.parseInt(text.substring(i1, i2).trim());
		
	}

	public int pageNumber() {
		String url = driver.getCurrentUrl();
		int i1 = url.indexOf("page=")+"page=".length();
		int i2 = url.lastIndexOf("&q=");
		return Integer.parseInt(url.substring(i1, i2).trim());
	}

	private By pageSelector(int n) {
		locator = String.format(locator, n);
		return By.xpath(locator);
	}
	public ResultsPage goTo(int n) {
		driver.findElement(pageSelector(n)).click();
		return new ResultsPage(driver);
	}

	public ResultsPage goToNextPage() {
		driver.findElement(NEXT).click();
		return new ResultsPage(driver);
	}

	public ResultsPage goToPrevPage() {
		driver.findElement(PREVIOUS).click();
		return new ResultsPage(driver);
	}
	
	
}
