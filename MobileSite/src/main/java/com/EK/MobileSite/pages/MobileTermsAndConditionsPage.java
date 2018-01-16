package com.EK.MobileSite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EK.MobileSite.base.Base;

public class MobileTermsAndConditionsPage extends Base {
	// Page Factory
	@FindBy(className = "gray-button")
	WebElement backButton;
	@FindBy(className = "head-bar cf")
	WebElement headingLabel;

	// Initializing Page Objects
	public MobileTermsAndConditionsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
}
