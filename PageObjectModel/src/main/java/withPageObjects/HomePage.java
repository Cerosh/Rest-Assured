package withPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	private final String   URL= "http://www.vpl.ca";
	private final  By SEARCH_BOX= By.id("edit-search");
	private final  By SEARCH_BTN= By.xpath("//input[@id='edit-submit']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void open() {
		driver.get(URL);

	}

	public void searchFor(String keyword) {
		WebElement searchBox = driver.findElement(SEARCH_BOX);
		searchBox.clear();
		searchBox.sendKeys(keyword);
		WebElement searchBtn = driver.findElement(SEARCH_BTN);
		searchBtn.click();

	}

}
