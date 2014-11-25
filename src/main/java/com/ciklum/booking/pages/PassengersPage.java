package com.ciklum.booking.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ciklum.booking.tools.RadioButton;
import com.ciklum.booking.tools.Util;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class PassengersPage extends PageObject {
	
	@FindBy(css="div.adult-passenger-editors > div > div.single-passenger-editor > "
			+ "div.single-passenger-item.single-passenger-name > "
			+ "div.passenger-item.name-passenger-item.single-passenger-title > select")
	private WebElementFacade _titleAdult;
	
	@FindBy(css="div.child-passenger-editors > div > div.single-passenger-editor >"
			+ " div.single-passenger-item.single-passenger-name > "
			+ "div.passenger-item.name-passenger-item.single-passenger-title > select")
	private WebElementFacade _titleChild;
	
	@FindBy(css="div.infant-passenger-editors > div > div.single-passenger-editor >"
			+ " div.single-passenger-item.single-passenger-name > "
			+ "div.passenger-item.name-passenger-item.single-passenger-title > select")
	private WebElementFacade _titleInfant;
	
	@FindBy(css="div.adult-passenger-editors > div > div.single-passenger-editor >"
			+ " div.single-passenger-item.single-passenger-name > "
			+ "div.passenger-item.name-passenger-item.single-passenger-first-name > input")
	private WebElementFacade _adultFirstName;
	
	@FindBy(css="div.adult-passenger-editors > div > div.single-passenger-editor >"
			+ " div.single-passenger-item.single-passenger-name > "
			+ "div.passenger-item.name-passenger-item.single-passenger-last-name > input")
	private WebElementFacade _adultLastName;
	
	@FindBy(css="div.child-passenger-editors > div > div.single-passenger-editor >"
			+ " div.single-passenger-item.single-passenger-name > "
			+ "div.passenger-item.name-passenger-item.single-passenger-first-name > input")
	private WebElementFacade _childFirstName;
	
	@FindBy(css="div.child-passenger-editors > div > div.single-passenger-editor >"
			+ " div.single-passenger-item.single-passenger-name > "
			+ "div.passenger-item.name-passenger-item.single-passenger-last-name > input")
	private WebElementFacade _childLastName;
	
	@FindBy(css="div.infant-passenger-editors > div > div.single-passenger-editor >"
			+ " div.single-passenger-item.single-passenger-name > "
			+ "div.passenger-item.name-passenger-item.single-passenger-first-name > input")
	private WebElementFacade _infantFirstName;
	
	@FindBy(css="div.infant-passenger-editors > div > div.single-passenger-editor >"
			+ " div.single-passenger-item.single-passenger-name > "
			+ "div.passenger-item.name-passenger-item.single-passenger-last-name > input")
	private WebElementFacade _infantLastName;
	
	@FindBy(css="div.contact-person-editor.booking-page-item input[type=checkbox]")
	private WebElementFacade _copyCheckBox;
	
	@FindBy(css="input.gwt-TextBox") //..required.email.validation-error.gwt-TextBox-emptyText")
	private WebElementFacade _inputs; //_email;
	
	@FindBy(css="input.gwt-TextBox required mobile-phone-country-text-box gwt-TextBox-emptyText")
	private WebElementFacade _mobile;
	
/*	@FindBy(css="div.contact-person-editor.booking-page-item")
	public WebElementFacade _contactPersonEditorDiv;
	
	private ContactPersonEditor _contactPersonEitor;*/
	
/*	public PassengersPage() {
		System.out.println(" *** div: " + _contactPersonEditorDiv);
		_contactPersonEitor = ContactPersonEditor.forWebElement(_contactPersonEditorDiv);
	}*/
	
	public void chooseAdultTitle(String adultTtl) {
		this.selectFromDropdown(_titleAdult, adultTtl);
	}
	
	public void chooseChildTitle(String childTtl) {
		this.selectFromDropdown(_titleChild, childTtl);
	}
	
	public void chooseInfantTitle(String infantTtl) {
		this.selectFromDropdown(_titleInfant, infantTtl);
	}
	
	
	public void enterAdultFirstName(String adlt) {
		this.typeInto(_adultFirstName, adlt);
	}
	
	public void enterAdultLastName(String adlt) {
		this.typeInto(_adultLastName, adlt);
	}
	
	public void enterChildFirstName(String chld) {
		this.typeInto(_childFirstName, chld);
	}
	
	public void enterChildLastName(String chld) {
		this.typeInto(_childLastName, chld);
	}
	
	public void enterInfantFirstName(String inft) {
		this.typeInto(_infantFirstName, inft);
	}
	
	public void enterInfantLastName(String inft) {
		this.typeInto(_infantLastName, inft);
	}
	
	public void markCopyCheckBox(){
//		_contactPersonEitor = ContactPersonEditor.forWebElement(_contactPersonEditorDiv);
		this.setCheckbox(_copyCheckBox, true);
//		By by = By.cssSelector("div.contact-person-editor.booking-page-item input[type=checkbox]");
//		this.waitForRenderedElementsToBePresent(by);
//		this.find(by).click();
//		_copyCheckBox.click();
//		this.waitFor(by);
	}
	
	public void enterEmail(String mail){
		
//		_contactPersonEditor.getCheckbox();
//		_checkB.click();
//		System.out.println(" *** _checkB: " + _checkB);
//		this.typeInto(_email, mail);
/*		System.out.println("*** text: " + _email.getText()
				+ " *** currently enabled: " + _email.isCurrentlyEnabled()
				+ " *** currently visible: " + _email.isCurrentlyVisible() 
				+ " *** displayed: " + _email.isDisplayed() 
				+ " *** enabled: " + _email.isEnabled() 
				+ " *** present: " + _email.isPresent() 
				+ " *** selected: " + _email.isSelected()
				+ " *** visible: " + _email.isVisible() 
				);*/
	}
	
	public void enterMobile(String mobile){
		this.typeInto(_mobile, mobile);
	}
	

/*	static class ContactPersonEditor {
		
		private final WebElementFacade _div;
		
		private ContactPersonEditor(WebElementFacade div) {
			this._div = div;
		}
		
		public static ContactPersonEditor forWebElement(final WebElementFacade div) {
			System.out.println(" *** Di: " + div);
			return new ContactPersonEditor(div);
		}
		
		public WebElementFacade getCheckbox() {
			return _div.find(By.cssSelector("input[type=checkbox]"));
		}
	}*/
}
