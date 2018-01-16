package com.EK.MobileSite.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.EK.MobileSite.base.Base;
import com.EK.MobileSite.util.Utility;

public class FlightSearchFromHomePageTest extends Base {
	Utility utility;
	
	public FlightSearchFromHomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		utility = new Utility();
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
}
