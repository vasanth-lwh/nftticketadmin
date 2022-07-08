package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	public WebDriver driver;
	By Signin = By.cssSelector("#nav-link-accountList");
	By Email = By.cssSelector("#ap_email");
	By Continue = By.xpath("//input[@id='continue']");
	By EmailEmptyError = By.cssSelector("div[id='auth-email-missing-alert'] div[class='a-alert-content']");
	By EmailInvalidError = By.cssSelector("ul[class='a-unordered-list a-nostyle a-vertical a-spacing-none'] li");
	By Password = By.cssSelector("#ap_password");
	By SigninSubmit = By.cssSelector("#signInSubmit");
	By PasswordInvalidError = By.cssSelector(".a-list-item");
	
	public LoginPage (WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public WebElement getSignin()
	{
		return driver.findElement(Signin);
	}
	public WebElement getEmail()
	{
		return driver.findElement(Email);
	}
	public WebElement getContinue()
	{
		return driver.findElement(Continue);
	}
	public WebElement getEmailEmptyError()
	{
		return driver.findElement(EmailEmptyError);
	}
	public WebElement getEmailInvalidError()
	{
		return driver.findElement(EmailInvalidError);
	}
	public WebElement getPassword()
	{
		return driver.findElement(Password);
	}
	public WebElement getSigninSubmit()
	{
		return driver.findElement(SigninSubmit);
	}
	public WebElement getPasswordInvalidError()
	{
		return driver.findElement(PasswordInvalidError);
	}
}
