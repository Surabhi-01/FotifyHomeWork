package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BeautyPage {
	
WebDriver driver ;
	
	public BeautyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//div[@class='category-tiles']/div/a/span[contains(text(),'Premium Deals')]")
	 public WebElement PremiumDealsBtn;
	
	@FindBy(xpath= "//div[@class='bestitem index-0']/div/a")
	 public WebElement FirstItem;
	
	@FindBy(xpath= "//div[@class='bestitem index-0']//a[@class='bt1 browsinglink']")
	 public WebElement FirstItemName;
	
	@FindBy(xpath= "//div[@class='bestitem index-0']//div[@class='compBlock']//following-sibling::span")
	 public WebElement FirstItemPriceBP;
	
}
