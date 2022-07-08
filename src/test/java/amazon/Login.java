package amazon;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resources.base;

public class Login extends base{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void Initialize() throws IOException, InterruptedException
	{
	driver=initializeDriver();
	log.info("Driver is initialized");
	driver.manage().window().maximize();
	log.info("Browser Window Maximized");
	driver.get(prop.getProperty("url"));
	log.info("Navigated to Signin page");

	}

	@Test (priority=1,description="To Verify the HomePage Title")
	public void titleVerification() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
	}
	
	@Test (priority=2,description="To Verify the Error Message When No Data is Entered")
	public void signinWithNoData() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		LoginPage LP = new LoginPage(driver);
		LP.getSignin().click();
		LP.getEmail().sendKeys("");
		LP.getContinue().click();
		Thread.sleep(3000);
		Assert.assertEquals(LP.getEmailEmptyError().getText(), "Enter your email or mobile phone number");
		System.out.println(LP.getEmailEmptyError().getText());
		Thread.sleep(2000);
	}
	
	@Test (priority=3,description="To Verify the Error Message When Email Id is Invalid")
	public void signinWithInvalidData() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		LoginPage LP = new LoginPage(driver);
		LP.getSignin().click();
		LP.getEmail().sendKeys("vasanth@modria.com");
		Thread.sleep(3000);
		LP.getContinue().click();
		Thread.sleep(3000);
		Assert.assertEquals(LP.getEmailInvalidError().getText(), "We cannot find an account with that email address");
		System.out.println(LP.getEmailInvalidError().getText());
		Thread.sleep(2000);
	}
	
	@Test (priority=4,description="To Verify the Error Message When Password is Invalid")
	public void signinWithInvalidPassword() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		LoginPage LP = new LoginPage(driver);
		LP.getSignin().click();
		LP.getEmail().sendKeys("vasanth@leewayhertz.com");
		LP.getContinue().click();
		Thread.sleep(2000);
		LP.getPassword().sendKeys("Admin@123");
		LP.getSigninSubmit().click();
		Thread.sleep(2000);
		Assert.assertEquals(LP.getPasswordInvalidError().getText(), "Your password is incorrect");
		System.out.println(LP.getPasswordInvalidError().getText());
		Thread.sleep(2000);
	}

	@Test (priority=5,description="To Verify if able to login with valid credentials")
	public void signinWithValidData() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		LoginPage LP = new LoginPage(driver);
		LP.getSignin().click();
		LP.getEmail().sendKeys("vasanth@leewayhertz.com");
		LP.getContinue().click();
		Thread.sleep(2000);
		LP.getPassword().sendKeys("Admin@123#");
		LP.getSigninSubmit().click();
		Thread.sleep(2000);
		//Assert.assertEquals(LP.getPasswordInvalidError().getText(), "Your password is ");
		//System.out.println(LP.getPasswordInvalidError().getText());
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void TearDown() throws IOException
	{
	driver.close();
	log.info("Browser Closed");
	}
}
