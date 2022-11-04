package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
	
WebDriver driver ;
	
	public AddCustomerTest()
	{
		this.driver = driver;
	}
	
	@Test
	@Parameters({"userName" , "password" , "dashBoardHeaderValidation" , "fullName" ,"company" ,"email" ,"phone" ,"Address" ,"City" ,"State"  ,"ZipCode" ,"Country" })
	public void userShouldAbleToLogin(String username , String password , String dashboardValidationText ,String name , String company , String email , String ph , String address , String city , String state , String zip ,  String country ) throws InterruptedException
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
		
		AddCustomerPage contact = PageFactory.initElements(driver, AddCustomerPage.class);
		contact.insertName(name);
		contact.selectCompany(company);
		contact.insertEmail(email);
		contact.insertPhone(ph);
		contact.insertAddress(address);
		contact.insertCity(city);
		contact.insertState(state);
		contact.insertZip(zip);
		contact.selectCountry(country);
		contact.clickSaveButton();
		
		Thread.sleep(3000);
		dash.clickListCustomer();
		
		//Thread.sleep(2000);
		//contact.listInstertedNameValidation();
	}


}
