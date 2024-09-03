package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VikunjaHome {
	WebDriver driver;
	WebDriverWait wait;
	
	private By loggedInUser = By.xpath("//span[@class='username']");
	private By logout = By.xpath("//span[normalize-space()='Logout']");
		
	public VikunjaHome(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public String LoggedUser() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUser));
		System.out.println(driver.findElement(loggedInUser).getText());
		return driver.findElement(loggedInUser).getText();
	}
}
