package POWithPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TotalResultsPage {
	WebDriver driver;
	private final By LABEL = By.xpath("//span[@class='items_showing_count']");

	public TotalResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public int count() {
		WebElement label = driver.findElement(LABEL);
		String text = label.getText();
		int i1 = text.indexOf("of") + 3;
		int i2 = text.indexOf("items");
		return Integer.parseInt(text.substring(i1, i2).trim());

	}

}
