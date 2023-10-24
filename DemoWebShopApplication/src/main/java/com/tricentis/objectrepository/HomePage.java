package com.tricentis.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(linkText = "Shopping cart")
	private WebElement shoppingCartLink;
	
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	private List<WebElement> addToCartButtons;

	@FindBy(xpath = "//p[contains(text(),'product has been added')]")
	private WebElement productAddedConfirmMsg;
	
	public List<WebElement> getAddToCartButtons() {
		return addToCartButtons;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getProductAddedConfirmMsg() {
		return productAddedConfirmMsg;
	}
	
	
}
