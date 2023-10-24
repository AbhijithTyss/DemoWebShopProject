package login;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tricentis.basetest.BaseClass;

public class TC_DWS_002_Test extends BaseClass{
	@Test(groups = "system")
	public void loginToApp() {
		Assert.assertEquals(homepage.getLogoutLink().isDisplayed(), true);
//		Reporter.log("User logged in successfully",true);
		test.log(Status.PASS, "User logged in successfully");
	}
}