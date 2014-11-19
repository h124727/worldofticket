package com.ciklum.booking.steps;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ciklum.booking.pages.BookingPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

@SuppressWarnings("serial")
public class EndUserSteps extends ScenarioSteps {

    BookingPage bookingPage;
    
    Random random = new Random();
    
    @Step
    public void gotoWebHomepage() {
    	bookingPage.open();
    }
    
    @Step
    public void chooseDepartureAirportFromDropdownList(String airport) {
    	bookingPage.chooseDepartureAirport(airport);
    }
    
    @Step
    public void chooseArrivalAirportFromDropdownList(String airport) {
    	bookingPage.chooseArrivalAirport(airport);
    }

    @Step
	public void checkRoundtripRadioButton() {
		bookingPage.checkRoundtripRadioButton();
	}

    @Step
	public void chooseAvailableDatesForOutboundAndInboundFlights() {
    	List<String> available = bookingPage.getAvailableDatesForOutboundFlight();
    	String randomAvailable = available.get(random.nextInt(available
    			.size() - 1));
    	chooseAvailableDateForOutboundFlight(randomAvailable);
		String inboundValue = Integer.toString(Integer.parseInt(randomAvailable) + 1);
    	chooseAvailableDateForInboundFlight(inboundValue);
	}
    
    @Step
    public void chooseAvailableDateForOutboundFlight(String outboundValue) {
    	bookingPage.chooseDateForOutboundFlight(outboundValue);
    }
    
    @Step
    public void chooseAvailableDateForInboundFlight(String inboundValue) {
    	bookingPage.chooseDateForInboundFlight(inboundValue);
    }
    
    @Step
    public void chooseNumberOfAdultFromDropdownList(int adultNum) {
    	bookingPage.chooseNumberOfAdult(adultNum);
    }
    
    @Step
    public void chooseNumberOfChildFromDropdownList(int childNum) {
    	bookingPage.chooseNumberOfChild(childNum);
    }
    
    @Step
    public void chooseNumberOfInfantFromDropdownList(int infantNum) {
    	bookingPage.chooseNumberOfInfant(infantNum);
    }
    
	@Step
	public void chooseNumberOfAdultChildInfantPassengers(int adultNum,
			int childNum, int infantNum) {
		chooseNumberOfAdultFromDropdownList(adultNum);
		chooseNumberOfChildFromDropdownList(childNum);
		chooseNumberOfInfantFromDropdownList(infantNum);
	}
    
    @Step
    public void chooseSearchPeriodFromDropdownList(String period) {
    	bookingPage.chooseSearchPeriod(period);
    }
    
    @Step
    public void chooseCurrencyFromDropdownList(String currency) {
    	bookingPage.chooseCurrency(currency);
    }
    
	@Step
	public void chooseOneFromAvailableCurrency() {
		chooseRandomDropdownItem(bookingPage.getCurrencyWebElement());
	}
    
	private void chooseRandomDropdownItem(WebElement dropdown) {
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		int randomItem = random.nextInt(options.size());
		select.selectByIndex(randomItem);
	}

    @Step
    public void pressGoButton() {
    	bookingPage.pressGoButton();
    }

		
    	
/*    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }


    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }*/
}