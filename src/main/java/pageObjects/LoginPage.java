package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	public WebDriver driver;
	By Email = By.cssSelector("#email");
	By Password = By.cssSelector("#password");
	By Signin = By.cssSelector("button[type='submit']");
	By PasswordEye = By.cssSelector("img[class='passIcon ? \" block cursor-pointer\" : \" hidden\" pr-5 w-11.25 h-6.5 cursor-pointer']");
	By EmailInvalidError = By.cssSelector(".mt-10");
	By PasswordInvalidError = By.cssSelector(".mt-4");
	By EmailClear = By.cssSelector("img[class='pr-5 block cursor-pointer']");
	By Header = By.cssSelector("h1[class='text-ft7 font-OpenSansSemiBold pt-7.5']");
	By RememberMe = By.cssSelector("#checkbox");
	By RememberMeLabel = By.cssSelector("p[class='font-OpenSansRegular text-ft4 text-darkGrey-100 pl-2.5']");
	
	public LoginPage (WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
	public WebElement getEmail()
	{
		return driver.findElement(Email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(Password);
	}
	public WebElement getSignin()
	{
		return driver.findElement(Signin);
	}
	public WebElement getPasswordEye()
	{
		return driver.findElement(PasswordEye);
	}
	public WebElement getEmailInvalidError()
	{
		return driver.findElement(EmailInvalidError);
	}
	public WebElement getPasswordInvalidError()
	{
		return driver.findElement(PasswordInvalidError);
	}
	public WebElement getEmailClear()
	{
		return driver.findElement(EmailClear);
	}
	public WebElement getHeader()
	{
		return driver.findElement(Header);
	}
	public WebElement getRememberMe()
	{
		return driver.findElement(RememberMe);
	}
	public WebElement getRememberMeLabel()
	{
		return driver.findElement(RememberMeLabel);
	}
}
