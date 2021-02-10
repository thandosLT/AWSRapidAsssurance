package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import browser.BaseClass;
import pages.homepage;

public class DemoTest extends BaseClass{

	public RemoteWebDriver _driver;
	public homepage home;
	
	
	public DemoTest()
	{
		home = new homepage(_driver);
		_driver = setup();
	}
	@Test(priority=1,groups="regression")
	public void DemoTestToBeReviewed()
	{
		try {
			home.loginUser(_driver).clickStartToBeReviewed(_driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
