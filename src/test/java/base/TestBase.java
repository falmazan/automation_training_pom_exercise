package base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class TestBase {

	private final String BASE_URL = "https://www.starbucks.com.mx/";

	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters({"driversPath"})
	public void setup(String driversPath) {
		
		System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(BASE_URL);
	}

	@AfterSuite
	public void closePage() {
		driver.quit();
	}

}
