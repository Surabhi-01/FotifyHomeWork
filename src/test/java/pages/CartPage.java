package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	
WebDriver driver ;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//div[@class='basketTab']//div[@class='nameContainer']/a")
	 public WebElement ItemNameCP;
	
	@FindBy(xpath= "//span[@class='avl']/span//following::td[2]")
	 public WebElement ItemPriceCP;
	
	@FindBy(xpath= "//span[@class='last price']")
	 public WebElement ItemLastPriceCP;
	
	@FindBy(xpath= "//div[@class='countInput']/div[@class='countMinus']")
	 public WebElement ItemMinusBtn;
	
	@FindBy(xpath= "//iframe[@id='_hjRemoteVarsFrame']")
	 public WebElement RemoveGoodsFrame;
	
	@FindBy(xpath= "//div[@id='alzaDialog']//span[contains(text(),'Remove goods')]")
	 public WebElement RemoveGoodsBtn;
	
	@FindBy(xpath= "//div[@class='del']")
	 public WebElement CloseDiscountSugg;
	
	@FindBy(xpath= "//span[contains(text(),'Apply Promo/Discount Code or Gift Voucher')]")
	 public WebElement PromocodeOrDiscountlink;
	
	@FindBy(xpath= "//input[@id='txtDiscountCode']")
	 public WebElement PromocodeOrDiscountField;
	
	@FindBy(xpath= "//input[@id='txtDiscountCode']//following-sibling::a")
	 public WebElement PromocodeOrDiscountAddBtn;
	
	@FindBy(xpath= "//div[contains(text(),'Gift Voucher activated')]")
	 public WebElement PromocodeAddedMsg;
	
	@FindBy(xpath= "//table[@class='o1discount']")
	public List<WebElement>GiftVoucherMsg;
	
	@FindBy(xpath= "//div[@id='infodialog']//a")
	 public WebElement NoVoucherdialogClose;
	
}
