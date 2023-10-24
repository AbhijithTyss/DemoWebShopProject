package shoppingcart;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tricentis.basetest.BaseClass;
import com.tricentis.objectrepository.ShoppingCartPage;

public class TC_DWS_004_Test extends BaseClass {
	@Test(groups = "system")
	public void removeProduct() throws EncryptedDocumentException, IOException {
		homepage.getAddToCartButtons().get(1).click();
		homepage.getShoppingCartLink().click();
		String EXPECTED_TITLE = eLib.getDataFromExcel("ShoppingCart", 1, 0);
		Assert.assertEquals(driver.getTitle(), EXPECTED_TITLE);
//		Reporter.log("shopping cart page is displayed",true);
		test.log(Status.INFO, "shopping cart page is displayed");
		ShoppingCartPage shoppingcart=new ShoppingCartPage(driver);
		shoppingcart.getRemoveCartCheckbox().click();
		shoppingcart.getUpdateShoppingCartButton().click();
		Assert.assertEquals(shoppingcart.getCartIsEmptyMsg().isDisplayed(), true);
//		Reporter.log("Product removed from shopping cart successfully",true);
		test.log(Status.PASS, "Product removed from shopping cart successfully");
	}
}
