package TestMethods;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MonsterPage;
import utility.BaseClass;

public class ApplyJobinMonster extends BaseClass {
	String uname = "muneendravipparthi@hotmail.com";
	String pwd = "munnabhai";
	String skills = "Selenium WebDriver";
	String location = "Hyderabad";

	BaseClass baseclass;
	MonsterPage monster;

	@BeforeClass
	public void initObjects() {
		baseclass = new BaseClass();
		driver = baseclass.driver;
		monster = new MonsterPage(driver);
	}

	@Parameters({ "uname", "pwd" })
	@Test(priority = 1)
	public void logintoMonster(String uname, String pwd) throws InterruptedException {
		monster.clickLoginLink();
		monster.enterUsername(uname, pwd);
		// monster.enterPassword(pwd);
		monster.clicksubmit();

		/*ArrayList tabs = new ArrayList(driver.getWindowHandles());
		if (tabs.size() > 0) {
			driver.switchTo().window((String) tabs.get(1)).close();
			driver.switchTo().window((String) tabs.get(0));
		}*/
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	public void searchJob() throws InterruptedException {
		monster.navigatetoJobsearch();
		Thread.sleep(5000);
		monster.enterSkills(skills);
		monster.enterLocation(location);
		monster.submitSearch();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	public void applyJob() throws InterruptedException {
		for (int i = 1; i <= 10; i++) {
			String element = "(//a[contains(text(),'Apply')])[" + i + "]";
			driver.findElement(By.xpath(element)).click();
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			Thread.sleep(3000);
			driver.switchTo().window((String) tabs.get(2)).close();
			driver.switchTo().window((String) tabs.get(0));
		}
	}
}
