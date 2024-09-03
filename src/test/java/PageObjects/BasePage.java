package PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static WebDriver driver;	
	Properties prop = new Properties();	
	FileReader fr;
	
	@BeforeMethod
	public void setup() throws IOException
	{		
		fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\appconfig.properties");
		prop.load(fr);		
		System.out.println(prop.getProperty("browser"));
		if(prop.getProperty("browser").equalsIgnoreCase("Chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	public String title() {
		return driver.getTitle();
	}
}
