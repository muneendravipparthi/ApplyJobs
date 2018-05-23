package TestMethods;

import java.net.URI;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.NaukriPage;

import utility.BaseClass;

public class ApplyJobinNaukri extends BaseClass {

	String uname = "vipparthimuneendra@gmail.com";
	String pwd = "munnabhai";
	String skills = "Selenium WebDriver";
	String location = "Hyderabad";
	String exp = "3 Years";
	String salary = "6 Lack";

	BaseClass baseclass;
	NaukriPage naukri;

	@BeforeClass
	public void initObjects() {
		baseclass = new BaseClass();
		driver = baseclass.driver;
		naukri = new NaukriPage(driver);
	}

	@Test(priority = 1)
	public void logintoNaukri() throws InterruptedException {
		naukri.clickLoginLink();
		Thread.sleep(5000);
		naukri.enterUsername(uname);
		naukri.enterPassword(pwd);
		naukri.clicksubmit();
		Thread.sleep(5000);
		
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(1)).close();
		driver.switchTo().window((String) tabs.get(2)).close();
		driver.switchTo().window((String) tabs.get(3)).close();
		driver.switchTo().window((String) tabs.get(0));
	}

	@Test(priority = 2)
	public void searchJobs() throws InterruptedException {
		naukri.enterSkills(skills);
		naukri.enterLocation(location);
		/*
		 * naukri.selectSalary(salary); naukri.enterExp(exp);
		 */
		naukri.submitSearch();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	public void getAllJobLinks() throws InterruptedException {
		for (int i = 3; i <= 10; i++) {
			String element = "//div[" + i + "]//a/ul/li";
			driver.findElement(By.xpath(element)).click();
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			Thread.sleep(5000);
			try {
				driver.findElement(By.xpath("//button")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("qupSubmit")).click();
				Thread.sleep(5000);
			} catch (Exception e) {
			}
			driver.close();
			driver.switchTo().window((String) tabs.get(0));
		}
	}
}
