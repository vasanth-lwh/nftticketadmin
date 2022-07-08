package nftTicketing;

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

public class Signin extends base{
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
	Thread.sleep(3000);
	}

	@Test
	public void SiginPage() throws IOException, InterruptedException
	{
		Assert.assertEquals(driver.getTitle(), "NFT Ticketing-SuperAdmin");
		System.out.println(driver.getTitle());
		LoginPage LP = new LoginPage(driver);
		Assert.assertEquals(LP.getHeader().getText(), "Login with nft ticketing");
		System.out.println(LP.getHeader().getText());
		Assert.assertEquals(LP.getEmail().getAttribute("placeholder"), "Email Address");
		System.out.println(LP.getEmail().getAttribute("placeholder"));
		Assert.assertEquals(LP.getPassword().getAttribute("placeholder"), "Password");
		System.out.println(LP.getPassword().getAttribute("placeholder"));
		Assert.assertEquals(LP.getSignin().getText(), "Sign in");
		System.out.println(LP.getSignin().getText());
		LP.getEmail().clear();
		LP.getEmail().sendKeys("vas");
		LP.getPassword().clear();	
		LP.getPassword().sendKeys("123");
		LP.getSignin().click();
		Assert.assertEquals(LP.getEmailInvalidError().getText(), "Please enter the valid email address");
		Assert.assertEquals(LP.getPasswordInvalidError().getText(), "Please enter the valid password");
		System.out.println(LP.getEmailInvalidError().getText());
		System.out.println(LP.getPasswordInvalidError().getText());
		Thread.sleep(3000);
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
		LP.getEmail().sendKeys("vasanth@leewayhertz.com");
		LP.getPassword().sendKeys("Admin@123");
		LP.getSignin().click();
		Thread.sleep(3000);
		Assert.assertEquals(LP.getEmailInvalidError().getText(), "User doesn't exist");
		Assert.assertEquals(LP.getPasswordInvalidError().getText(), "Invalid password");
		System.out.println(LP.getEmailInvalidError().getText());
		System.out.println(LP.getPasswordInvalidError().getText());
		Thread.sleep(3000);
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
		LP.getEmail().sendKeys("shivanib+1@leewayhertz.com");
		LP.getPassword().sendKeys("admin@12345");
		LP.getSignin().click();
		Thread.sleep(10000);
	}

	@AfterTest
	public void TearDown() throws IOException
	{
	driver.close();
	log.info("Browser Closed");
	}
}
