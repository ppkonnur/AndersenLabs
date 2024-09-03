package TestCaes;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

import PageObjects.*;
import Utilities.ReadExcelData;

public class SanityTests extends BasePage{
	//public static Logger log = LogManager.getLogger(SanityTests.class);
	
	@Test(dataProviderClass = ReadExcelData.class, dataProvider = "testData")
	public void createAccount(String username, String email, String Password) throws InterruptedException {
		ViKunjaLogin login = new ViKunjaLogin(driver);		
		System.out.println(title());
		login.createAccount(username, email, Password);
		VikunjaHome home = new VikunjaHome(driver);		
		assertEquals(home.LoggedUser(), username, "Logged In User doesnt match");
	}
	
	@Test(dataProviderClass = ReadExcelData.class, dataProvider = "testData")
	public void verifyInvalidUser(String username, String email, String Password, String errMsg) throws InterruptedException {
		ViKunjaLogin login = new ViKunjaLogin(driver);
		login.createAccount(username, email, Password);
		assertEquals(login.InvalidUserName(), errMsg, "Error Msg Not Displayed");
	}
	
	@Test(dataProviderClass = ReadExcelData.class, dataProvider = "testData")
	public void userLogin(String username, String Password) throws InterruptedException {
		ViKunjaLogin login = new ViKunjaLogin(driver);
		
		login.login(username, Password);
		VikunjaHome home = new VikunjaHome(driver);
		assertEquals(home.LoggedUser(), username, "User Not Logged In");
	}
	
}
