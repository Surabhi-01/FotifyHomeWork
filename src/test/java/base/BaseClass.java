package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver ;
	

	@BeforeMethod
	public void LaunchBrowser() throws Exception
	{
		
		Reporter.log("=====Browser session Started=====");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		PropertiesFile propfile = new PropertiesFile();
		driver.get(PropertiesFile.getPropertyValuebyKey("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	@AfterMethod
	public void CloseBrowser()
	{
		this.driver.quit();
		Reporter.log("====Browser session End====");
	}

}
