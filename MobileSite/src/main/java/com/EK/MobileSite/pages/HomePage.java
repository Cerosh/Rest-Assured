package com.EK.MobileSite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EK.MobileSite.base.Base;

public class HomePage extends Base {
	// Page Factory
	@FindBy(id = "hom_hom_bookFlt")
	WebElement bookAFlight;

	@FindBy(id = "hom_hom_fltStus")
	WebElement flightStatus;
	
	@FindBy(id = "hom_hom_olci")
	WebElement onlineCheckin;
	
	@FindBy(id = "hom_hom_mngBk")
	WebElement manageABooking;

	@FindBy(id = "hom_hom_ff")
	WebElement featuredFares;
	
	@FindBy(xpath = "//a[text()='Terms and conditions']")
	WebElement termsAndConditions;

	// Initializing Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public FlightSearchFromHomePage clickOnMakeAFlighLink() {
		bookAFlight.click();
		return new FlightSearchFromHomePage();
	}

	public FlightStatusPage clickOnFlightStatusLink() {
		flightStatus.click();
		return new FlightStatusPage();
	}
	
	public OnlineCheckInPage clikcOnOnlineCheckInLink() {
		onlineCheckin.click();
		return new OnlineCheckInPage();
	}
	
	public ManageABookingPage clickOnManageABookingLink() {
		manageABooking.click();
		return new ManageABookingPage();
	}
	public FeaturedFaresPages clickOnFeaturedFaresPages() {
		featuredFares.click();
		return new FeaturedFaresPages();
	}

	public MobileTermsAndConditionsPage clickOnMobileTermsAndConditionsLink() {
		termsAndConditions.click();
		return new MobileTermsAndConditionsPage();
	}
}
