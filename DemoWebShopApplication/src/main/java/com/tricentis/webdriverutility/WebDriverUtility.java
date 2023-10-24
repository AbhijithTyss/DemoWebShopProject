package com.tricentis.webdriverutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {

	public void mouseHover(WebDriver driver,WebElement ele) {
		Actions action=new Actions(driver);
		action.moveToElement(ele).perform();
	}
	
}
