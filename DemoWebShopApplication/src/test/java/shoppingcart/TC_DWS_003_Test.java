package shoppingcart;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tricentis.basetest.BaseClass;
import com.tricentis.objectrepository.ShoppingCartPage;

public class TC_DWS_003_Test extends BaseClass {
	@Test(groups = "system")
	public void addProduct() {
		homepage.getAddToCartButtons().get(1).click();
		Assert.assertEquals(homepage.getProductAddedConfirmMsg().isDisplayed(), true);
//		Reporter.log("Product added message is Displayed",true);
		test.log(Status.INFO, "Product added message is Displayed");
		homepage.getShoppingCartLink().click();
		boolean productStatus = driver.findElement(By.xpath("//td[@class='product']")).isDisplayed();
		Assert.assertEquals(productStatus, true);
//		Reporter.log("Product added in shopping cart successfully",true);
		test.log(Status.PASS, "Product added in shopping cart successfully");
	}
}
