package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViKunjaLogin {
	WebDriver driver;
	WebDriverWait wait;
	
	private By username = By.id("username");
	private By email = By.name("email");
	private By password = By.xpath("//input[@id='password']");
	private By createButton = By.cssSelector("#register-submit");
	private By invalidDataMsg = By.xpath("//div[@class='message danger']");
	private By requiredUsername = By.xpath("//p[@class='help is-danger']");
	private By loginLink = By.xpath("//a[@href='/login']");
	private By loginButton = By.xpath("//button[normalize-space()='Login']");
	
	public ViKunjaLogin(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}	
	
	public void createAccount(String username, String email, String password) throws InterruptedException {		
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.email).sendKeys(email);		
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.createButton).click();		
	}
	
	public String InvalidUserName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidDataMsg));
		return driver.findElement(invalidDataMsg).getText();
	}
	
	public void clickLogin() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,document.documentElement.scrollHeight)", "");
	    driver.findElement(loginLink).click();
	}
	
	public void login(String username, String password) throws InterruptedException {		
		clickLogin();
		driver.findElement(this.username).sendKeys(username);			
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginButton).click();		
	}
}
