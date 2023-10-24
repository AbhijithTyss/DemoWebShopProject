package register;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.reporters.EmailableReporter;

import com.tricentis.fileutility.ExcelUtility;
import com.tricentis.fileutility.FileUtility;
import com.tricentis.objectrepository.HomePage;
import com.tricentis.objectrepository.RegisterPage;

public class TC_DWS_001 {

	@Test
	public void registerToApp() throws IOException {
		// step 1: open browser
		WebDriver driver = new ChromeDriver();
		FileUtility fLib = new FileUtility();
		String URL = fLib.getDataFromPropertyFile("url");
		ExcelUtility eLib = new ExcelUtility();
		// reading data from excel by using method "getDataFromExcel" present in
		// ExcelUtility class
		String FIRSTNAME = eLib.getDataFromExcel("Register", 1, 0);
		String LASTNAME = eLib.getDataFromExcel("Register", 1, 1);
		String EMAIL = eLib.getDataFromExcel("Register", 1, 2);
		String PASSWORD = eLib.getDataFromExcel("Register", 1, 3);
		String CONFIRMPASSWORD = eLib.getDataFromExcel("Register", 1, 4);
		String EXPECTED_TITLE = eLib.getDataFromExcel("Register", 1, 5);
		// step 2: navigate to url
		driver.get(URL);
		Assert.assertEquals(driver.getTitle(), EXPECTED_TITLE);
		Reporter.log("WelCome page is displayed", true);

		HomePage homepage = new HomePage(driver);
		// step 3: Click on "Register" link
		RegisterPage registerpage = new RegisterPage(driver);
		homepage.getRegisterLink().click();

		Assert.assertEquals(registerpage.getRegisterText().isDisplayed(), true);
		Reporter.log("Register page is displayed", true);
		// step 4
		registerpage.getMaleRadioButton().click();
		// step 5
		registerpage.getFirstNameTextField().sendKeys(FIRSTNAME);
		// step 6
		registerpage.getLastNameTextField().sendKeys(LASTNAME);
		// step 7
		registerpage.getEmailTextField().sendKeys(EMAIL);
		// step 8
		registerpage.getPasswordTextField().sendKeys(PASSWORD);
		// step 9
		registerpage.getConfirmPasswordTextField().sendKeys(CONFIRMPASSWORD);
		// step 10
		registerpage.getRegisterButton().click();
		// validate or check point
		Assert.assertEquals(registerpage.getRegisterCompleteMsg().isDisplayed(), true);
		Reporter.log("User registered successfully", true);
	}
}