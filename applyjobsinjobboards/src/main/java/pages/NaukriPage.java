package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NaukriPage {
	WebDriver driver;

	By loginlink = By.xpath("//a[@id='login_Layer']/div");

	// login details
	By username = By.id("eLogin");
	By password = By.id("pLogin");
	By submitbtn = By.xpath("//button[@value='Login']");

	// search functionality
	By enterskills = By.id("qsb-keyskill-sugg");
	By enterlocation = By.id("qsb-location-sugg");
	By clickexperience = By.id("expDroope-experienceFor");
	By selectsalary = By.id("salaryDroope-salaryFor");
	By submitsearch = By.xpath("//button[@type='submit']");

	public NaukriPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickLoginLink() {
		driver.findElement(loginlink).click();
	}

	public void enterUsername(String uname) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
	}

	public void clicksubmit() {
		driver.findElement(submitbtn).click();
	}

	public void enterSkills(String skills) {
		driver.findElement(enterskills).clear();
		driver.findElement(enterskills).sendKeys(skills);
	}

	public void enterLocation(String location) {
		driver.findElement(enterlocation).clear();
		driver.findElement(enterlocation).sendKeys(location);
	}

	public void enterExp(String exp) {
		driver.findElement(clickexperience).click();
		driver.findElement(By.linkText(exp)).click();
	}

	public void selectSalary(String salary) {
		driver.findElement(selectsalary).click();
		driver.findElement(By.linkText(salary)).click();
	}
	
	public void submitSearch() {
		driver.findElement(submitsearch).click();
	}
}
