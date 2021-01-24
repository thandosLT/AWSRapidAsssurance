package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class click {
	public RemoteWebDriver _driver;
	//public timeouts wait; 
	
	public click(RemoteWebDriver driver) {
		this._driver = driver;
		//wait = new timeouts(driver);
	}

	public void Click(RemoteWebDriver driver, By elementLocation) {
        //wait.waitVisibility(elementLocation);
        driver.findElement(elementLocation).click();
    }
}
