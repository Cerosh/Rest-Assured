package com.EK.MobileSite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EK.MobileSite.base.Base;

public class FlightStatusPage extends Base {
	// Page Factory
	@FindBy(id = "flight-number")
	WebElement flightNumberTestBox;
	@FindBy(id = "fls_fltSrch_instantSearchBtn")
	WebElement checkFlightStatusButton;
	@FindBy(id = "search_by_route_tab")
	WebElement searchByRouteTab;
	
	// Initializing Page Objects
	public FlightStatusPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
}
