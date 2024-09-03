package Utilities;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageObjects.BasePage;

public class Utils extends BasePage{

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Utils ut = new Utils();
//		ut.getScreenshot();
//	}	
	
	public void getScreenshot(String testName) {
		Date currentdate = new Date();
		System.out.println(currentdate);
		String screenshotFileName = testName+"_"+currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotFileName);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File(".//screenshot//"+screenshotFileName +".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
}
