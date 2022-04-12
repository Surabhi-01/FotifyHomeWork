package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {
	
WebDriver driver ;
	
	public BooksPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "(//div[@class='MuiScopedCssBaseline-root']//div[contains(@class,'swiper-slide')])[4]")
	 public WebElement Book4;
	
	@FindBy(xpath= "(//div[@class='MuiScopedCssBaseline-root']//div[contains(@class,'swiper-slide')])[4]//a[2]/div")
	 public WebElement Book4Name;
	
	@FindBy(xpath= "(//div[@class='MuiScopedCssBaseline-root']//div[contains(@class,'swiper-slide')])[4]//a[2]//following::span[2]")
	 public WebElement Book4NPrice;
}
