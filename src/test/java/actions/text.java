package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class text {
	public RemoteWebDriver _driver;
		
	public text(RemoteWebDriver driver) {
		this._driver = driver;
	}
	
	public String readText(RemoteWebDriver driver, By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
	
	public void writeText(RemoteWebDriver driver, By elementLocation, String text) {
		driver.findElement(elementLocation).sendKeys(text);
	}
}
