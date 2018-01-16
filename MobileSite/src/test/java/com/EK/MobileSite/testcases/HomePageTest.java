package com.EK.MobileSite.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.EK.MobileSite.base.Base;
import com.EK.MobileSite.pages.FeaturedFaresPages;
import com.EK.MobileSite.pages.FlightSearchFromHomePage;
import com.EK.MobileSite.pages.FlightStatusPage;
import com.EK.MobileSite.pages.HomePage;
import com.EK.MobileSite.pages.ManageABookingPage;
import com.EK.MobileSite.pages.MobileTermsAndConditionsPage;
import com.EK.MobileSite.pages.OnlineCheckInPage;
import com.EK.MobileSite.pages.PageFooters;
import com.EK.MobileSite.util.Utility;

public class HomePageTest extends Base {
	HomePage homepage;
	FlightSearchFromHomePage flightSearchFromHomePage;
	FlightStatusPage flightStatusPage;
	MobileTermsAndConditionsPage mobileTermsAndConditionsPage;
	OnlineCheckInPage onlineCheckinPage;
	ManageABookingPage manageABookingPage;
	FeaturedFaresPages featuredFaresPage;
	PageFooters pageFooters;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		homepage = new HomePage();

	}

	@Test(priority = 1)
	public void HomePageTitleTest() {
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "Emirates | Book flights, hotels and car rental - Emirates");
	}

	@Test(priority = 2)
	public void verifyMakeABookingLink() {
		flightSearchFromHomePage = homepage.clickOnMakeAFlighLink();
	}

	@Test(priority = 3)
	public void verifyFlightStatusLink() {
		flightStatusPage = homepage.clickOnFlightStatusLink();
	}

	@Test(priority = 4)
	public void verifyMobileTermsAndConditionsLink() {
		mobileTermsAndConditionsPage = homepage.clickOnMobileTermsAndConditionsLink();
	}

	@Test
	public void verifyOnlineCheckinLink() {
		onlineCheckinPage = homepage.clikcOnOnlineCheckInLink();
	}
	
	@Test
	public void verifyManageABookingLink() {
		manageABookingPage = homepage.clickOnManageABookingLink();
	}
	@Test
	public void verifyFeaturedFareLink() {
		featuredFaresPage = homepage.clickOnFeaturedFaresPages();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
