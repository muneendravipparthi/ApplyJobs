package TestMethods;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LinkedInPage;
import utility.BaseClass;

public class ApplyJobinLinkedIn extends BaseClass {
	String uname = "muneendravipparthi@gmail.com";
	String pwd = "munnabhai";
	String skills = "Selenium WebDriver";
	String location = "Hyderabad";

	BaseClass baseclass;
	LinkedInPage linkedin;

	@BeforeClass
	public void initObjects() {
		baseclass = new BaseClass();
		driver = baseclass.driver;
		linkedin = new LinkedInPage(driver);
	}

	@Parameters({ "uname", "pwd" })
	@Test(priority = 0)
	public void logintoLinkedIn(String uname, String pwd) throws InterruptedException {
		linkedin.enterUsername(uname);
		linkedin.enterPassword(pwd);
		linkedin.clickSubmit();
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void searchJobs() throws InterruptedException {
		linkedin.clickJobLink();
		Thread.sleep(5000);
		linkedin.enterSkills(skills);
		linkedin.enterLocation(location);
		linkedin.submitSearch();
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	public void applytoJob() throws InterruptedException {
		for (int i = 1; i <= 15; i++) {
			String urlLink = driver.findElement(By.xpath("//li["+i+"]/div/div[2]/div/div/a/div/h3")).getText();
			System.out.println(urlLink);
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
			driver.findElement(By.linkText(urlLink)).sendKeys(selectLinkOpeninNewTab);
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			try {
				driver.findElement(By.xpath("//div/div[3]/div/div/button")).click();
			}catch (Exception e) {
			}
			driver.close();
			Thread.sleep(3000);
			driver.switchTo().window((String) tabs.get(0));
		}
	}
}
