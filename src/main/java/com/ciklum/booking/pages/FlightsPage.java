package com.ciklum.booking.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ciklum.booking.tools.RadioButton;

//@DefaultUrl("http://staging.worldticket.net")
public class FlightsPage extends PageObject {

	@FindBy(css = "table.gwt-TabPanel.flight-search-page-item.flight-search-page-tab-panel")
	private WebElementFacade _outboundTable;
	
	@FindBy(css = "table.gwt-TabPanel.flight-search-page-item.flight-search-page-tab-panel-inbound")
	private WebElementFacade _inboundTable;
	
	@FindBy(css = "button.gwt-Button.next-page-button")
	private WebElementFacade _nextButton;
	
	@FindBy(css = "span.price.total-value")
	private WebElementFacade _priceCalculatorTotalValue;
	
	@SuppressWarnings("unchecked")
	public List<RadioButton> getOutboundPriceRadioButtons() {
		List<RadioButton> buttons = new ArrayList<RadioButton>();
		for (WebElement div : _outboundTable.findElements(By.cssSelector("div.fare-price-cell-item.fare-price-cell-radion"))) {
			buttons.add(RadioButton.forWebElement(div));
		}
		return buttons.isEmpty() ? Collections.EMPTY_LIST : buttons;
	}
	
	@SuppressWarnings("unchecked")
	public List<RadioButton> getInboundPriceRadioButtons() {
		List<RadioButton> buttons = new ArrayList<RadioButton>();
		for (WebElement div : _inboundTable.findElements(By.cssSelector("div.fare-price-cell-item.fare-price-cell-radion"))) {
			buttons.add(RadioButton.forWebElement(div));
		}
		return buttons.isEmpty() ? Collections.EMPTY_LIST : buttons;
	}

	public void pressNextButton() {
		_nextButton.click();
	}
	
	public String getTotalPriceValue() {
		return _priceCalculatorTotalValue.getText();
	}
	
}
