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

public class LoginTextVerification extends base{
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
	public void LoginLabels() throws IOException, InterruptedException
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
	}

	@AfterTest
	public void TearDown() throws IOException
	{
	driver.close();
	log.info("Browser Closed");
	}
}
