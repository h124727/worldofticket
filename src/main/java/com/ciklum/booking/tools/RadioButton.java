package com.ciklum.booking.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioButton {
	
    private final WebElement div;
	
    private RadioButton(WebElement div) {
		this.div = div;
	}

	public static RadioButton forWebElement(final WebElement div) {
        return new RadioButton(div);
    }
	
	public WebElement getInput() {
		return div.findElement(By.cssSelector("input"));
	}
	
	public WebElement getLabel() {
		return div.findElement(By.cssSelector("label"));
	}

}
