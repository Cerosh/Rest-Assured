package withPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage {
	private WebDriver driver;
	private final By COUNT = By.xpath("//span[@class='items_showing_count']");
	private final String URL = "https://vpl.bibliocommons.com/search";

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isOpen() {

		return driver.getCurrentUrl().contains(URL);
	}

	public int count() {
		WebElement label = driver.findElement(COUNT);
		String text = label.getText();
		int i1 = text.indexOf("of") + 3;
		int i2 = text.indexOf("items");
		return Integer.parseInt(text.substring(i1, i2).trim());
	}

}
