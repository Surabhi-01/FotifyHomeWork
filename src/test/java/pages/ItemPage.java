package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {

	
WebDriver driver ;
	
	public ItemPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//h1[@itemprop='name']")
	 public WebElement ItemName;
	
	@FindBy(xpath= "//span[@class='bigPrice price_withVat']")
	 public WebElement ItemPrice;
	
	@FindBy(xpath= "//a[@data-lb-action='buy']/span[contains(text(),'Add to Cart')]")
	 public WebElement AddtoCartBtn;
	
	@FindBy(xpath= "(//a[@class='btn green']/span[contains(text(),'Proceed to Checkout')])[1]")
	 public WebElement CheckoutBtn;
	
	@FindBy(xpath= "//span[@class='shoppingListsAdd']")
	 public WebElement AddFavBtn;
	
	@FindBy(xpath= "//div[@class='browsingitemcontainer']/div[1]")
	 public WebElement SearchResult1;
	
	@FindBy(xpath= "(//div[@class='browsingitemcontainer']/div[1]//a)[1]")
	 public WebElement SearchResult1img;
	
	@FindBy(xpath= "//div[@class='discountCode']")
	 public WebElement DiscountCode;
	
	@FindBy(xpath= "//span[@class='priceWithCashBack']")
	 public WebElement DiscountedPrice;
	

	
}
