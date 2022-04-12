package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavouritesPage {
	
WebDriver driver ;
	
	public FavouritesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//div[@class='items']//a[@class='name']")
	 public WebElement FavItemName;
	
	@FindBy(xpath= "//div[@class='items']//a[@class='name']//following::span[2]")
	 public WebElement FavItemPrice;
	
	@FindBy(xpath= "//div[@class='items']//div[@class='close']")
	 public WebElement RemoveFavBtn;

}
