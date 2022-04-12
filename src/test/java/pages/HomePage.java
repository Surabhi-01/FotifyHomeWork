package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver ;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//div[@id='alzaDialog']//div[@class='close']")
	public WebElement popUpCloseBtn;

	@FindBy(xpath= "//a[contains(text(),'I understand')]")
	public WebElement UnderstandBtn;

	@FindBy(xpath= "//a[@id='lblLogin']")
	public WebElement loginBtn;

	@FindBy(xpath= "//iframe[@id='loginIframe']")
	public WebElement LoginFrame;

	@FindBy(xpath= "//input[@id='userName']")
	private WebElement EmailID;

	@FindBy(xpath= "//input[@id='password']")
	private WebElement pwd;

	public void setUsername(String username) {
		EmailID.sendKeys(username);
	}

	public void setPassword(String password) {
		pwd.sendKeys(password);
	}

	@FindBy(xpath= "//button[@id='btnLogin']")
	public WebElement LoginBtn;

	public HomePage clickSignInButton() {
		LoginBtn.click();
		return new HomePage(driver);
	}

	public HomePage login(String username, String password) {
		setUsername(username);
		setPassword(password);
		return clickSignInButton();
	}

	@FindBy(xpath= "//a[@id='registerLink']")
	public WebElement RegistrationBtn;

	@FindBy(xpath="//span[@id='loginButtonText']")
	public WebElement ErrorText;

	@FindBy(xpath="//ul[@class='fmenu']/li/a[contains(text(),'Beauty')]")
	public WebElement BeautyCategoryOption;

	@FindBy(xpath="//ul[@class='fmenu']/li/a[contains(text(),'Books')]")
	public WebElement BooksCategoryOption;

	@FindBy(xpath="//a[@class='loggedUser']")
	public WebElement UserPageBtn;

	@FindBy(xpath="//a[@class='icon fav']")
	public WebElement FavPageBtn;
	
	@FindBy(xpath="//input[@id='edtSearch']")
	public WebElement SearchField;
	
	@FindBy(xpath="//div[@id='btnSearch']")
	public WebElement SearchBtn;
}
