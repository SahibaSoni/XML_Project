package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	
	WebDriver driver ;
	
	public LoginTest()
	{
		this.driver = driver;
	}
	
	@Test
	@Parameters({"userName" , "password" , "dashBoardHeaderValidation"})
	public void userShouldAbleToLogin(String username , String password , String dashboardValidationText)
	{
		driver = BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(username);
		login.insertPassword(password);
		login.clickSignIn();
		
		DashboardPage dash = PageFactory.initElements(driver, DashboardPage.class);
		dash.dashboardValidation(dashboardValidationText);
		dash.clickCustomer();
		dash.clickAddCustomer();
	}

}
