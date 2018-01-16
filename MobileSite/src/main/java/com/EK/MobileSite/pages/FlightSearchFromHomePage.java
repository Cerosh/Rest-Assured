package com.EK.MobileSite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.EK.MobileSite.base.Base;

public class FlightSearchFromHomePage extends Base {
	// Page Factory
	@FindBy(id = "departureId")
	WebElement departureTextBox;
	@FindBy(id = "arrivalId")
	WebElement arrivalTextBox;
	@FindBy(id = "cabinPax")
	WebElement selectPassenger;
	@FindBy(xpath = "//button[@ng-disabled='searchData.paxDetails.adultCount >= searchData.paxDetails.adultMax']")
	WebElement adultPassengerDropDown;
	@FindBy(id = "radio_9")
	WebElement economyClass;
	@FindBy(xpath = "//section[@class='section-ht ng-scope']/preceding::button[@class='cabin-pessanger-proceed-btn ng-binding']")
	WebElement submitButton;

	// Initializing Page Objects
	public FlightSearchFromHomePage() {
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("departureId")));
	}
	// Actions
}
