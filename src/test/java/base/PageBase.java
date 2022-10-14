package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class PageBase {

	private Actions actions;
	private JavascriptExecutor js;
	private Alert allowLocationAlert;

	protected WebDriver driver;

	public static Logger log = Logger.getLogger(PageBase.class);	

	public PageBase(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
	}

	protected void moveToElement(WebElement element) {
		actions.moveToElement(element).perform();
	}

	protected void scrollToItem(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	protected void acceptAlert() {
		try {
			this.allowLocationAlert = driver.switchTo().alert();
			allowLocationAlert.accept();
		}catch(NoAlertPresentException e) {
			log.info("This alert was previously accepted");
		}
	}

	protected void sendKeys(WebElement element, Keys key) {
		element.sendKeys(key);
	}

}
