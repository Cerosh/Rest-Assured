package POWithReturnPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	private final String URL = "http://www.vpl.ca";
	private final By SEARCH_TXBX = By.id("edit-search");
	private final By SEARCH_BTN = By.id("edit-submit");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void open() {
		driver.get(URL);

	}

	public ResultsPage searchFor(String string) {
		WebElement search_Txtbx = driver.findElement(SEARCH_TXBX);
		search_Txtbx.clear();
		search_Txtbx.sendKeys(string);
		WebElement search_Btn = driver.findElement(SEARCH_BTN);
		search_Btn.click();
		return new ResultsPage(driver);
	}

	

}
