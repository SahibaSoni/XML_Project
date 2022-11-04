package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	
	WebDriver driver;
	
	public AddCustomerPage()
	{
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'account']") WebElement fullnameElement;
	@FindBy(how = How.XPATH, using = "//select[@id = 'cid']" ) WebElement companyElement;
	@FindBy(how = How.XPATH, using = "//input[@id = 'email']") WebElement emailElement;
	@FindBy(how = How.XPATH, using = "//input[@id = 'phone']") WebElement phoneElement;
	@FindBy(how = How.XPATH, using = "//input[@id = 'address']") WebElement addressElement;
	@FindBy(how = How.XPATH, using = "//input[@id = 'city']") WebElement cityElement;
	@FindBy(how = How.XPATH, using = "//input[@id = 'state']") WebElement stateElement;
	@FindBy(how = How.XPATH, using = "//input[@id = 'zip']") WebElement zipElement;
	@FindBy(how = How.XPATH, using = "//select[@id = 'country']") WebElement countryElement;
	
	@FindBy(how = How.XPATH , using = "//button[@id = 'submit']" )WebElement submitElement;
	String insertedName;
	public void insertName(String name)
	{
		insertedName = name+generateRandomNum(999);
		fullnameElement.sendKeys(insertedName );
	
	}
	public void selectCompany(String company)
	{
		selectDropDown(companyElement , company);
	}
	
	public void insertEmail(String email)
	{
		emailElement.sendKeys(generateRandomNum(999) + email);
	}
	public void insertPhone(String ph)
	{
		phoneElement.sendKeys(generateRandomNum(999) + ph);
	}
	public void insertAddress(String add)
	{
		addressElement.sendKeys(add);
	}
	public void insertCity(String city)
	{
		addressElement.sendKeys(city);
	}
	public void insertState(String state)
	{
		addressElement.sendKeys(state);
	}
	public void insertZip(String zip)
	{
		addressElement.sendKeys(zip);
	}
	public void selectCountry(String country)
	{
		selectDropDown(countryElement , country);
	}
	public void clickSaveButton()
	{
		submitElement.click();
		
	}
	// //tbody/tr[1]/td[3]/a
	// //tbody/tr[2]/td[3]/a
	// //tbody/tr[3]/td[3]/a
	
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]/a";
	
	public void listInstertedNameValidation()
	{

		for (int i = 1; i<= 10; i++) 
		{
			String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(actualName);
			Assert.assertEquals(actualName, insertedName, "Name not found");
			break;
		}
	}
	

}
