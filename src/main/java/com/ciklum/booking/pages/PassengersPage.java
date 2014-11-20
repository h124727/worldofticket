package com.ciklum.booking.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class PassengersPage extends PageObject {
	
	@FindBy(css="#booking_wizard_widget > div > "
			+ "div.wizard-container > div > div.booking-third-page-body > "
			+ "div.booking-third-page-items >"
			+ " div.passengers-editors.passenger-editors-container.booking-page-item > "
			+ "div.inner-passenger-editors-container > div.passengers-container > "
			+ "div.adult-passenger-editors > div > div.single-passenger-editor > "
			+ "div.single-passenger-item.single-passenger-name > "
			+ "div.passenger-item.name-passenger-item.single-passenger-title > select")
	private WebElementFacade _titleAdult;
	
	@FindBy(css="#booking_wizard_widget > div > div.wizard-container > div > "
			+ "div.booking-third-page-body > div.booking-third-page-items > "
			+ "div.passengers-editors.passenger-editors-container.booking-page-item >"
			+ " div.inner-passenger-editors-container > div.passengers-container >"
			+ " div.child-passenger-editors > div > div.single-passenger-editor >"
			+ " div.single-passenger-item.single-passenger-name > "
			+ "div.passenger-item.name-passenger-item.single-passenger-title > select")
	private WebElementFacade _titleChild;
	
	@FindBy(css="#booking_wizard_widget > div > div.wizard-container > div > "
			+ "div.booking-third-page-body > div.booking-third-page-items >"
			+ " div.passengers-editors.passenger-editors-container.booking-page-item > "
			+ "div.inner-passenger-editors-container > div.passengers-container >"
			+ " div.infant-passenger-editors > div > div.single-passenger-editor >"
			+ " div.single-passenger-item.single-passenger-name > "
			+ "div.passenger-item.name-passenger-item.single-passenger-title > select")
	private WebElementFacade _titleInfant;
	
	
	public void chooseAdultTitle(String adultTtl) {
		this.selectFromDropdown(_titleAdult, adultTtl);
	}
	
	public void chooseChildTitle(String childTtl) {
		this.selectFromDropdown(_titleChild, childTtl);
	}
	
	public void chooseInfantTitle(String infantTtl) {
		this.selectFromDropdown(_titleInfant, infantTtl);
	}
	
	
	
}
