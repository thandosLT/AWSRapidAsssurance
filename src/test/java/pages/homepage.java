package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import actions.click;
import actions.text;
import browser.BaseClass;

public class homepage extends BaseClass{
	public RemoteWebDriver _driver;
	private text aText;
	private click aClick;
	
	public homepage(RemoteWebDriver driver) {
		  this._driver = driver;
		  aText = new text(driver);
		  aClick = new click(driver);
	  }
	
	//Elements
	By LoginEmail = By.xpath("//input[@id='email']");
	By NextButton = By.xpath("//button[@class='btn login-btn mt-3']");
	By Otp = By.xpath("//input[@id='otp_val']");
	By SubmitOtp = By.xpath("//button[@id='submit_otp']");
	

	public Responsibleuserloggedinpage loginUser(RemoteWebDriver driver) throws InterruptedException
	{
		
		try {
			enterTextHomePageElement(driver, LoginEmail, "thandos1503@gmail.com");
			clickHomePageElement(driver, NextButton);
			enterTextHomePageElement(driver, Otp, "12345");
			clickHomePageElement(driver, SubmitOtp);
			Thread.sleep(500);
			
		}
		catch(Exception e) {
			
		}
		return new Responsibleuserloggedinpage(_driver);
	}
	
	private void clickHomePageElement(RemoteWebDriver driver, By element)
	{
		aClick.Click(driver, element);
	}
	
	private void enterTextHomePageElement(RemoteWebDriver driver, By element, String text)
	{
		aText.writeText(driver, element, text);
	}
	
	
	
}
