package com.ciklum.booking.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://staging.worldticket.net")
public class BookingPage extends PageObject {
	
	@FindBy(css="select.gwt-ListBox.departure-airport")
	private WebElementFacade departingDropdown;
	
	@FindBy(css="select.gwt-ListBox.arrival-airport")
	private WebElementFacade arrivalDropdown;
	
	@FindBy(css="span.gwt-RadioButton.roundtrip-button")
	private WebElementFacade roundtripRadioButton;
	
	@FindBy(css="div.outbound-calendar")
	private WebElementFacade outboundCalendar;
	
	@FindBy(css="div.inbound-calendar")
	private WebElementFacade inboundCalendar;
	
	@FindBy(css="div.passenger-types-container > div:nth-child(1) > select")
	private WebElementFacade numberOfAdult;

	@FindBy(css="div.passenger-types-container > div:nth-child(2) > select")
	private WebElementFacade numberOfChild;

	@FindBy(css="div.passenger-types-container > div:nth-child(3) > select")
	private WebElementFacade numberOfInfant;
	
	@FindBy(css="select.gwt-ListBox.search-period")
	private WebElementFacade _searchPeriod;
	
	@FindBy(css="select.gwt-ListBox.currencies")
	private WebElementFacade _currency;
	
	@FindBy(css="a.gwt-Anchor.go-button")
	private WebElementFacade _goButton;

	public WebElementFacade getCurrencyWebElement() {
		return _currency;
	}
/*    @FindBy(name="search")
    private WebElementFacade searchTerms;

    @FindBy(name="go")
    private WebElementFacade lookupButton;*/
	
	public void chooseDepartureAirport(String airport) {
		this.selectFromDropdown(departingDropdown, airport);
	}
	
	public void chooseArrivalAirport(String airport) {
		this.selectFromDropdown(arrivalDropdown, airport);
	}

	public void checkRoundtripRadioButton() {
		roundtripRadioButton.find(By.cssSelector("input")).click();
	}
	
	public List<String> getAvailableDatesForOutboundFlight() {
		
		List<WebElement> availableCells = getAvailableCellsInCalendar(outboundCalendar);
		
		List<String> available = new ArrayList<String>(availableCells.size());
		
		for (WebElement cell : availableCells) {
			available.add(cell.getText());
		}
		
		return available;
	}

	public void chooseDateForOutboundFlight(String outboundValue) {
		clickCalendarCell(outboundCalendar, outboundValue);
	}

	public void chooseDateForInboundFlight(String inboundValue) {
		clickCalendarCell(inboundCalendar, inboundValue);
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
			if (!td.getAttribute("class").contains("OutsideOfMonth")) {
				available.add(td);
			}
		}
		return available;
	}
	
	public void chooseNumberOfAdult(int num) {
		this.selectFromDropdown(numberOfAdult, String.valueOf(num));
	}
/*    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        List<WebElement> results = definitionList.findElements(By.tagName("li"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }*/

	public void chooseNumberOfChild(int num) {
		this.selectFromDropdown(numberOfChild, String.valueOf(num));	
	}

	public void chooseNumberOfInfant(int num) {
		this.selectFromDropdown(numberOfInfant, String.valueOf(num));	
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
}
