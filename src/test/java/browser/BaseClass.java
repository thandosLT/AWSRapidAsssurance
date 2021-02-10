package browser;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

		//ConfigFileReader();
		
		//String baseUrl = properties.getProperty("BaseUrl");
		String browserType = "DesktopChromeBrowser";
		
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			
			if(browserType == "DesktopMobileEmulator") {
								
			}
			else if(browserType == "DesktopChromeBrowser") {
				
				caps.setBrowserName("chrome");
				//caps.setPlatform(Platform.LINUX);//AWS Cloud
				caps.setPlatform(Platform.WINDOWS);//local
				
				_driver = new RemoteWebDriver(new URL("http://192.168.8.100:4444/wd/hub"), caps);
				//_driver = new RemoteWebDriver(new URL("https://18.132.190.37/:4444/wd/hub"), caps);
				/*debug*/
				//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
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
	
	private void ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
}
