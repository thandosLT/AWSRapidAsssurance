package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class scroll {
public RemoteWebDriver _driver;
	
	
	public scroll(RemoteWebDriver driver) {
		this._driver = driver;
		
	}

	public void ScrollToElement(RemoteWebDriver driver, By elementLocation) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", elementLocation);
    }
	
	public void ScrollBy(RemoteWebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
	}
	
	public void MoveToElement(RemoteWebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element);
    }

}
