package com.ciklum.booking;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.ciklum.booking.requirements.Application;
import com.ciklum.booking.steps.EndUserSteps;
import com.ciklum.booking.tools.Util;

@Story(Application.Booking.TicketReservation.class)
@RunWith(ThucydidesRunner.class)
public class TicketReservationStoryTest {

    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://staging.worldticket.net")
    public Pages pages;

    @Steps
    public EndUserSteps endUser;

    @Test
    @Screenshots(onlyOnFailures=true)
    public void roundtripReservationShouldBeCreated() {
        endUser.gotoWebHomepage();											// 1
        endUser.chooseDepartureAirportFromDropdownList("London, LHR");//"Oslo, OSL");		// 2
        endUser.chooseArrivalAirportFromDropdownList("Copenhagen, CPH");	// 3
        endUser.checkRoundtripRadioButton();								// 4
        endUser.chooseAvailableDatesForOutboundAndInboundFlights();			// 5
        endUser.chooseNumberOfAdultChildInfantPassengers(1, 1, 1);			// 6
        endUser.chooseSearchPeriodFromDropdownList("Exact date");           // 7
        endUser.chooseOneFromAvailableCurrency();							// 8
        endUser.pressGoButton();                                            // 9
        // *** next page ***
        endUser.chooseCheapestFareBasisForInboundAndOutboundFlights();		// 10
//        Util.sleep(10, "before Next");
        endUser.pressNext();												// 11
        
        // ***
        Util.sleep(5, "for exit");
    }

    @Pending @Test
    public void onewayReservationShouldBeCreated() {
    }

} 
