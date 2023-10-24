package com.tricentis.basetest;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tricentis.fileutility.ExcelUtility;
import com.tricentis.fileutility.FileUtility;
import com.tricentis.javautility.JavaUtility;
import com.tricentis.objectrepository.HomePage;
import com.tricentis.objectrepository.LoginPage;


public class BaseClass {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public ExtentTest test;
	public JavaUtility jLib=new JavaUtility();
	public static WebDriver driver;
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public HomePage homepage;
	public LoginPage loginpage;
	
	@BeforeSuite(alwaysRun = true)
	public void configReports() {
		String TIME = jLib.getSysTime();
		spark=new ExtentSparkReporter("./reports/ExtentReport_"+TIME+".html");
		report=new ExtentReports();
		report.attachReporter(spark);
	}
	@Parameters("browserName")
	@BeforeClass(alwaysRun = true)
	public void browserSetup(@Optional("chrome") String browserName) throws IOException {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String URL = fLib.getDataFromPropertyFile("url");
		driver.get(URL);
	}
	@BeforeMethod(alwaysRun = true)
	public void login(Method method) throws EncryptedDocumentException, IOException {	
		test=report.createTest(method.getName());
		homepage=new HomePage(driver);
		homepage.getLoginLink().click();
		loginpage=new LoginPage(driver);
		String EMAIL = eLib.getDataFromExcel("Login", 1, 0);
		String PASSWORD = eLib.getDataFromExcel("Login", 1, 1);
		loginpage.getEmailTextField().sendKeys(EMAIL);
		loginpage.getPasswordTextField().sendKeys(PASSWORD);
		loginpage.getLoginButton().click();
	}
	@AfterMethod(alwaysRun = true)
	public void logout() {
		homepage.getLogoutLink().click();
	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void reportBackup() {
		report.flush();
	}
}
