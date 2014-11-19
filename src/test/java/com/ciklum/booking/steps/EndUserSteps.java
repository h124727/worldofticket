package com.ciklum.booking.steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ciklum.booking.pages.FlightsPage;
import com.ciklum.booking.pages.StartPage;
import com.ciklum.booking.tools.RadioButton;
import com.ciklum.booking.tools.Util;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

@SuppressWarnings("serial")
public class EndUserSteps extends ScenarioSteps {

    StartPage startPage;
    FlightsPage flightsPage;
    
    Random random = new Random();
    
    @Step
    public void gotoWebHomepage() {
    	startPage.open();
    }
    
    @Step
    public void chooseDepartureAirportFromDropdownList(String airport) {
    	startPage.chooseDepartureAirport(airport);
    }
    
    @Step
    public void chooseArrivalAirportFromDropdownList(String airport) {
    	startPage.chooseArrivalAirport(airport);
    }

    @Step
	public void checkRoundtripRadioButton() {
		startPage.checkRoundtripRadioButton();
	}

    @Step
	public void chooseAvailableDatesForOutboundAndInboundFlights() {
    	List<String> available = startPage.getAvailableDatesForOutboundFlight();
    	String randomAvailable = available.get(random.nextInt(available
    			.size() - 1));
    	chooseAvailableDateForOutboundFlight(randomAvailable);
		String inboundValue = Integer.toString(Integer.parseInt(randomAvailable) + 1);
    	chooseAvailableDateForInboundFlight(inboundValue);
	}
    
    @Step
    public void chooseAvailableDateForOutboundFlight(String outboundValue) {
    	startPage.chooseDateForOutboundFlight(outboundValue);
    }
    
    @Step
    public void chooseAvailableDateForInboundFlight(String inboundValue) {
    	startPage.chooseDateForInboundFlight(inboundValue);
    }
    
    @Step
    public void chooseNumberOfAdultFromDropdownList(int adultNum) {
    	startPage.chooseNumberOfAdult(adultNum);
    }
    
    @Step
    public void chooseNumberOfChildFromDropdownList(int childNum) {
    	startPage.chooseNumberOfChild(childNum);
    }
    
    @Step
    public void chooseNumberOfInfantFromDropdownList(int infantNum) {
    	startPage.chooseNumberOfInfant(infantNum);
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
    	startPage.chooseSearchPeriod(period);
    }
    
    @Step
    public void chooseCurrencyFromDropdownList(String currency) {
    	startPage.chooseCurrency(currency);
    }
    
	@Step
	public void chooseOneFromAvailableCurrency() {
		chooseRandomDropdownItem(startPage.getCurrencyWebElement());
	}
    
	private void chooseRandomDropdownItem(WebElement dropdown) {
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		int randomItem = random.nextInt(options.size());
		select.selectByIndex(randomItem);
	}

    @Step
    public void pressGoButton() {
    	startPage.pressGoButton();
    }
    
    @Step
	public void chooseCheapestFareBasisForInboundAndOutboundFlights() {

    	List<RadioButton> outButtons = flightsPage.getOutboundPriceRadioButtons();
    	List<Integer> outPrices = new ArrayList<Integer>(outButtons.size());
    	
    	for (RadioButton rb : outButtons) {
    		outPrices.add(Util.parseNumbersInString(rb.getLabel().getText()).get(0));
    	}
    	Integer outMin = Collections.min(outPrices);
    	
    	for (RadioButton rb : outButtons) {
    		if (rb.getLabel().getText().contains(outMin.toString())) {
    			rb.getInput().click();
    			break;
    		};
    	}
    	
    	List<RadioButton> buttons = flightsPage.getInboundPriceRadioButtons();
    	List<Integer> prices = new ArrayList<Integer>(buttons.size());
    	
    	for (RadioButton rb : buttons) {
    		prices.add(Util.parseNumbersInString(rb.getLabel().getText()).get(0));
    	}
    	Integer min = Collections.min(prices);
    	
    	for (RadioButton rb : buttons) {
    		if (rb.getLabel().getText().contains(min.toString())) {
    			rb.getInput().click();
    			break;
    		};
    	}
    	
	}

    @Step
	public void pressNext() {
		flightsPage.pressNextButton();
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