package com.tricentis.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="removefromcart")
	private WebElement removeCartCheckbox;
	
	@FindBy(name="updatecart")
	private WebElement updateShoppingCartButton;
	
	@FindBy(xpath = "//div[contains(text(),'Cart is empty!')]")
	private WebElement cartIsEmptyMsg;

	
	public WebElement getCartIsEmptyMsg() {
		return cartIsEmptyMsg;
	}

	public WebElement getRemoveCartCheckbox() {
		return removeCartCheckbox;
	}

	public WebElement getUpdateShoppingCartButton() {
		return updateShoppingCartButton;
	}
}
