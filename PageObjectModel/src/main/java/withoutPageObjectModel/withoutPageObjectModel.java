package withoutPageObjectModel;

import static org.testng.Assert.assertTrue;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class withoutPageObjectModel {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "/Users/ceroshjacob/Downloads/PageObjectModel/Browserdrivers/chromedriver");	
		driver = new ChromeDriver();
	}

	@Test
	public void validateSuccesfullLogin() throws InterruptedException {
		driver.get("http://thedemosite.co.uk/login.php");
		assertTrue(driver.getTitle().equals("Login example page to test the PHP MySQL online system"));

		WebElement uName = driver.findElement(By.xpath("//input[@name='username']"));
		uName.sendKeys("Cerosh");
		WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
		password.sendKeys("cerosh");
		WebElement loginBtn = driver.findElement(By.xpath("//input[@name='FormsButton2']"));
		loginBtn.click();
		WebElement usrLabel = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		String outPut = usrLabel.getText();
		assertTrue(outPut.equals("**Successful Login**"));

	}

	@AfterClass()
	public void afterClass() throws InterruptedException {
		driver.quit();
		driver = null;
	}

}
