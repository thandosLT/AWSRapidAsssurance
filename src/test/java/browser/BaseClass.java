package browser;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BaseClass {

	public RemoteWebDriver _driver;
	
	//@BeforeTest
	public RemoteWebDriver setup() {
		
		String browserType = "DesktopChromeBrowser";
		
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			
			if(browserType == "DesktopMobileEmulator") {
								
			}
			else if(browserType == "DesktopChromeBrowser") {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				_driver = new ChromeDriver();
				_driver.get("http://uat.rapidassurance.ai/");
			}
			
			_driver.manage().window().maximize();
			
		}catch(Exception exp) {
			System.out.println("Cause is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
		}
		return _driver;
	}
	
	@BeforeMethod
    public void methodLevelSetup() {
        
    }
	
	@AfterTest
	public void teardown() {
		_driver.close();
		_driver.quit();
	}
	
	
}
