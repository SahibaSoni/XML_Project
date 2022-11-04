package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	
	WebDriver driver ;
	
	
	public DashboardPage()
	{
		this.driver = driver;
	}

	@FindBy(how = How.XPATH , using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2" )WebElement DashBoardElement;
	@FindBy(how = How.XPATH , using = "//span[text() = 'Customers']" )WebElement customerElement;
	@FindBy(how = How.XPATH , using = "//a[text() = 'Add Customer']" )WebElement addCustomerElement;
	@FindBy(how = How.XPATH , using = "//a[text() = 'List Customers']" )WebElement ListCustomerElement;
	
	public void dashboardValidation(String expected)
	{
		Assert.assertEquals(DashBoardElement.getText(), expected, "page not found");
	}
	
	public void clickCustomer()
	{
		customerElement.click();
	}
	
	public void clickAddCustomer()
	{
		addCustomerElement.click();
	}
	
	public void clickListCustomer()
	{
		ListCustomerElement.click();
	}
	
	
}
