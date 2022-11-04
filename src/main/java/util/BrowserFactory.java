package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	
	public static WebDriver driver ;
	static String url = "https://www.techfios.com/billing/?ng=admin/";
	
	
	public static WebDriver init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lalit\\git\\xml\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
