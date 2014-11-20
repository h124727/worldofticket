package com.ciklum.booking.pages;

import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@DefaultUrl("http://staging.worldticket.net")
public class StartPage extends PageObject {
	
	@FindBy(css="select.gwt-ListBox.departure-airport")
	private WebElementFacade _departingDropdown;
	
	@FindBy(css="select.gwt-ListBox.arrival-airport")
	private WebElementFacade _arrivalDropdown;
	
	@FindBy(css="span.gwt-RadioButton.roundtrip-button")
	private WebElementFacade _roundtripRadioButton;
	
	@FindBy(css="div.outbound-calendar")
	private WebElementFacade _outboundCalendar;
	
	@FindBy(css="div.inbound-calendar")
	private WebElementFacade _inboundCalendar;
	
	@FindBy(css="div.passenger-types-container > div:nth-child(1) > select")
	private WebElementFacade _numberOfAdult;

	@FindBy(css="div.passenger-types-container > div:nth-child(2) > select")
	private WebElementFacade _numberOfChild;

	@FindBy(css="div.passenger-types-container > div:nth-child(3) > select")
	private WebElementFacade _numberOfInfant;
	
	@FindBy(css="select.gwt-ListBox.search-period")
	private WebElementFacade _searchPeriod;
	
	@FindBy(css="select.gwt-ListBox.currencies")
	private WebElementFacade _currency;
	
	@FindBy(css="a.gwt-Anchor.go-button")
	private WebElementFacade _goButton;
	
	public StartPage(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().setScriptTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public WebElementFacade getCurrencyWebElement() {
		return _currency;
	}
	
	public void chooseDepartureAirport(String airport) {
		this.selectFromDropdown(_departingDropdown, airport);
	}
	
	public void chooseArrivalAirport(String airport) {
		this.selectFromDropdown(_arrivalDropdown, airport);
	}

	public void checkRoundtripRadioButton() {
		_roundtripRadioButton.find(By.cssSelector("input")).click();
	}
	
	public List<String> getAvailableDatesForOutboundFlight() {
		return getAvailableDatesForCalendar(_outboundCalendar);
	}
	
	public List<String> getAvailableDatesForInboundFlight() {
		return getAvailableDatesForCalendar(_inboundCalendar);
	}

	public void chooseDateForOutboundFlight(String outboundValue) {
		clickCalendarCell(_outboundCalendar, outboundValue);
	}

	public void chooseDateForInboundFlight(String inboundValue) {
		clickCalendarCell(_inboundCalendar, inboundValue);
	}
	
	public void chooseNumberOfAdult(int num) {
		this.selectFromDropdown(_numberOfAdult, String.valueOf(num));
	}

	public void chooseNumberOfChild(int num) {
		this.selectFromDropdown(_numberOfChild, String.valueOf(num));	
	}

	public void chooseNumberOfInfant(int num) {
		this.selectFromDropdown(_numberOfInfant, String.valueOf(num));	
	}

	public void chooseSearchPeriod(String period) {
		this.selectFromDropdown(_searchPeriod, period);
	}
	
	public void chooseCurrency(String currency) {
		this.selectFromDropdown(_currency, currency);
	}
	
	public void pressGoButton() {
		_goButton.click();
	}
	
	private List<String> getAvailableDatesForCalendar(WebElementFacade calendar) {
		List<WebElement> availableCells = getAvailableCellsInCalendar(calendar);
		
		List<String> available = new ArrayList<String>(availableCells.size());
		
		for (WebElement cell : availableCells) {
			available.add(cell.getText());
		}
		return available;
	}
	
	private void clickCalendarCell(WebElementFacade calendar, String cellValue) {
		List<WebElement> tds = getAvailableCellsInCalendar(calendar);
		for (WebElement td : tds) {
			if (td.getText().equals(cellValue)) {
				td.click();
			}
		}
	}
	
	private List<WebElement> getAvailableCellsInCalendar(WebElementFacade calendar) {
		List<WebElement> tds = calendar.findElements(
				By.cssSelector("td.calendarCell"));
		
		List<WebElement> available = new ArrayList<WebElement>();
		
		for (WebElement td : tds) {
			if (td.getAttribute("class").contains("HasFlights")) {//"OutsideOfMonth")) {
				available.add(td);
			}
		}
		return available;
	}
}
