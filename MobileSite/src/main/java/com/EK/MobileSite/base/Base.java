package com.EK.MobileSite.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.EK.MobileSite.util.Utility;
import com.EK.MobileSite.util.WebEventListener;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public Base() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/ceroshjacob/eclipse-workspace/MobileSite/src/main/java/com/EK/MobileSite/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() throws InterruptedException {
		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/Browserdrivers/chromedriver");
			driver = new ChromeDriver();
			
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.Page_Load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.Implict_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
