package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkedInPage {
	WebDriver driver;
	By username = By.id("login-email");
	By password = By.id("login-password");
	By submitbtn = By.id("login-submit");

	By joblink = By.xpath("//li[@id='jobs-nav-item']/a/span[2]");
	By enterskills = By.xpath("//input[2]");
	By enterlocation = By.xpath("//div[2]/artdeco-typeahead-deprecated/artdeco-typeahead-deprecated-input/input[2]");
	By submitsearch = By.cssSelector("button.jobs-search-box__submit-button.button-secondary-large-inverse");

	public LinkedInPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String uname) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		;
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
		;
	}

	public void clickSubmit() {
		driver.findElement(submitbtn).click();
		;
	}

	public void clickJobLink() {
		driver.findElement(joblink).click();
		;
	}

	public void enterSkills(String skills) {
		driver.findElement(enterskills).clear();
		driver.findElement(enterskills).sendKeys(skills);
		;
	}

	public void enterLocation(String location) {
		driver.findElement(enterlocation).clear();
		driver.findElement(enterlocation).sendKeys(location);
		;
	}

	public void submitSearch() {
		driver.findElement(submitsearch).click();
	}
}
