package browser;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BaseClass {

	public RemoteWebDriver _driver;
	private Properties properties;
	private final String propertyFilePath= "config.properties";
	
	//@BeforeTest
	public RemoteWebDriver setup() {
		
		
		
		String browserType = "DesktopChromeBrowser";
		
		String browser = PropertiesFile.getBrowser();
		String baseurl = PropertiesFile.getBaseUrl();
		String gridvalue = PropertiesFile.getGridValue();
		
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			
			if(browserType == "DesktopMobileEmulator") {
								
			}
			else if(browserType == "DesktopChromeBrowser") {
				
				caps.setBrowserName(browser);
				//caps.setPlatform(Platform.LINUX);//AWS Cloud
				caps.setPlatform(Platform.WINDOWS);//local
				
				_driver = new RemoteWebDriver(new URL(gridvalue), caps);
				_driver = new ChromeDriver();
				_driver.get(baseurl);
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
