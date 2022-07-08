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

public class LoginIncorrectData extends base{
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
	public void LoginInvalidData() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		LoginPage LP = new LoginPage(driver);
		LP.getEmail().clear();
		LP.getEmail().sendKeys("vas");
		LP.getPassword().clear();	
		LP.getPassword().sendKeys("123");
		LP.getSignin().click();
		Assert.assertEquals(LP.getEmailInvalidError().getText(), "Please enter the valid email address");
		Assert.assertEquals(LP.getPasswordInvalidError().getText(), "Please enter the valid password");
		Thread.sleep(3000);
	}

	@AfterTest
	public void TearDown() throws IOException
	{
	driver.close();
	log.info("Browser Closed");
	}
}
