package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
	public static WebDriver driver = null;
	
	@Parameters({"url"})
	@BeforeTest
	public void loadWebBrowser(String url) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//BrowserDrivers//chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("http://www.naukri.com");
		//driver.get("https://www.linkedin.com");
		//driver.get("http://www.monsterindia.com/");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@AfterTest
	public void closeWebBrowser() {
		//driver.close();
		driver = null;
	}
}
