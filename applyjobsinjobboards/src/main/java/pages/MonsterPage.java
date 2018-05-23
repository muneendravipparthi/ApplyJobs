package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MonsterPage {
	WebDriver driver;

	By loginlink = By.linkText("Sign In");

	// login details
	By username = By.id("username_login");
	By password = By.id("password_input");
	By submitbtn = By.id("button");

	By jobsearch = By.xpath("//a[contains(text(),'Job Search')]");
	// search functionality
	By enterskills = By.id("fts_id");
	By enterlocation = By.id("lmy");
	By submitsearch = By.xpath("//input[@value='Search']");

	public MonsterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickLoginLink() {
		driver.findElement(loginlink).click();
	}

	public void enterUsername(String uname,String pwd) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname+ Keys.TAB+ pwd);
	}

	/*public void enterPassword(String pwd) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
	}*/

	public void clicksubmit() {
		driver.findElement(submitbtn).click();
	}
	
	public void navigatetoJobsearch() {
		driver.findElement(jobsearch).click();
	}

	public void enterSkills(String skills) {
		driver.findElement(enterskills).clear();
		driver.findElement(enterskills).sendKeys(skills);
	}

	public void enterLocation(String location) {
		driver.findElement(enterlocation).clear();
		driver.findElement(enterlocation).sendKeys(location);
	}

	public void submitSearch() {
		driver.findElement(submitsearch).click();
	}
}
