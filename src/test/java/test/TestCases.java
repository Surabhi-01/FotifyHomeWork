package test;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import base.PropertiesFile;
import pages.BeautyPage;
import pages.BooksPage;
import pages.CartPage;
import pages.FavouritesPage;
import pages.HomePage;
import pages.ItemPage;


public class TestCases extends BaseClass{
	
	@Test (description = "Verify Login functionality")
	public void UserLoginTC1() throws Exception
	{
		HomePage home = new HomePage(driver);
		home.popUpCloseBtn.click();
		home.UnderstandBtn.click();
		home.loginBtn.click();
		
		driver.switchTo().frame(home.LoginFrame);
		home.login(PropertiesFile.getPropertyValuebyKey("EmailID"), PropertiesFile.getPropertyValuebyKey("password"));
		WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(home.UserPageBtn));
		
		Assert.assertTrue(home.UserPageBtn.isDisplayed());
		
	}
	
	@Test (description = "Verify Login functionality with invalid password")
	public void InvalidUserLoginTC2() throws Exception
	{
		HomePage home = new HomePage(driver);
		home.popUpCloseBtn.click();
		home.UnderstandBtn.click();
		home.loginBtn.click();
		
		driver.switchTo().frame(home.LoginFrame);
		home.login(PropertiesFile.getPropertyValuebyKey("EmailID"), PropertiesFile.getPropertyValuebyKey("WrongPswd"));
		String ActualErrorMsg = home.ErrorText.getText();
		System.out.println(ActualErrorMsg);
		String ExpectedlErrorMsg = "Invalid username or password";
		Assert.assertEquals(ActualErrorMsg, ExpectedlErrorMsg);
		
	}
	
	
	@Test(description = "Verify adding an item from Beauty category to cart and validate details in Cart")
	public void ValidateBeautyItemTC3() throws Exception
	{
		HomePage home = new HomePage(driver);
		home.popUpCloseBtn.click();
		home.UnderstandBtn.click();
		home.loginBtn.click();
		
		driver.switchTo().frame(home.LoginFrame);
		home.login(PropertiesFile.getPropertyValuebyKey("EmailID"), PropertiesFile.getPropertyValuebyKey("password"));
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(home.BeautyCategoryOption));
		
		home.BeautyCategoryOption.click();
		BeautyPage beauty = new BeautyPage(driver);
		beauty.PremiumDealsBtn.click();
		
		String FirstItemName = beauty.FirstItemName.getText();
		System.out.println("FirstItemName: "+FirstItemName);
		String ItemPriceBP = beauty.FirstItemPriceBP.getText();
		System.out.println("ItemPriceBP: "+ItemPriceBP);
		beauty.FirstItem.click();
		ItemPage item = new ItemPage(driver);
		String ItemName = item.ItemName.getText();
		System.out.println("ItemName: "+ItemName);
		String itemPrice = item.ItemPrice.getText();
		System.out.println("itemPrice: "+itemPrice);
		
		item.AddtoCartBtn.click();
		
		item.CheckoutBtn.click();
		
		CartPage cart = new CartPage(driver);
		String ItemNameCP = cart.ItemNameCP.getText();
		System.out.println("ItemNameCP: "+ItemNameCP);
		
		String ItemPriceCP = cart.ItemPriceCP.getText();
		System.out.println("ItemPriceCP: "+ItemPriceCP);
		
		String ItemPCP[] = ItemPriceCP.split(" ");
		String ItemPricCP = ItemPCP[0];
		System.out.println(ItemPricCP);
		
		Assert.assertEquals(FirstItemName,FirstItemName );
		Assert.assertEquals(ItemPriceBP, itemPrice);
		
		Assert.assertTrue((ItemNameCP.contains(ItemName)));
		Assert.assertTrue((itemPrice.contains(ItemPricCP)));
		
		cart.ItemMinusBtn.click();
		cart.RemoveGoodsBtn.click();
		
	}

	
	@Test(description = "Verify adding 4th book from Books category to Favourites and verify details in Favourites page")
	public void ValidateFavouriteItemTC4() throws Exception
	{
		HomePage home = new HomePage(driver);
		home.popUpCloseBtn.click();
		home.UnderstandBtn.click();
		home.loginBtn.click();
		
		driver.switchTo().frame(home.LoginFrame);
		home.login(PropertiesFile.getPropertyValuebyKey("EmailID"), PropertiesFile.getPropertyValuebyKey("password"));
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(home.BooksCategoryOption));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", home.BooksCategoryOption);
		
		home.BooksCategoryOption.click();
		
		BooksPage book = new BooksPage(driver);
		
		js.executeScript("arguments[0].scrollIntoView();",book.Book4);
		
		String BookNameBsP = book.Book4Name.getText();
		System.out.println("BookNameBsP: "+BookNameBsP);
		String BookPriceBsP = book.Book4NPrice.getText();
		System.out.println("BookNameBsP: "+BookNameBsP);
		
		book.Book4.click();
		
		ItemPage item = new ItemPage(driver);
	    String BookNameIP = item.ItemName.getText();
	    System.out.println("BookNameIP: "+BookNameIP);
	    String BookPriceIP = item.ItemPrice.getText();
	    System.out.println("BookPriceIP: "+BookPriceIP);
	    
	    Assert.assertEquals(BookNameBsP,BookNameIP );
		Assert.assertEquals(BookPriceBsP, BookPriceIP);
	    
	    item.AddFavBtn.click();
	    
	    home.UserPageBtn.click();
	    home.FavPageBtn.click();
	    
	    FavouritesPage fav = new FavouritesPage(driver);
	    
	    String FavItemName = fav.FavItemName.getText();
	    String FavItemPrice = fav.FavItemPrice.getText();
	    
	    String ItemPCP[] = FavItemPrice.split(" ");
		String ItemPricCP = ItemPCP[0];
		System.out.println(ItemPricCP);
	    
	    Assert.assertTrue((BookNameIP.contains(FavItemName)));
		Assert.assertTrue((BookPriceIP.contains(ItemPricCP)));
		
		fav.RemoveFavBtn.click();
	}
	
	
	@Test(description = "Search a particular item and add it to cart and verify discount coupon on cart page")
	public void ValidateSearchandDiscountTC5() throws Exception
	{
		HomePage home = new HomePage(driver);
		home.popUpCloseBtn.click();
		home.UnderstandBtn.click();
		home.loginBtn.click();
		
		driver.switchTo().frame(home.LoginFrame);
		home.login(PropertiesFile.getPropertyValuebyKey("EmailID"), PropertiesFile.getPropertyValuebyKey("password"));
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(home.SearchField));
		
		home.SearchField.sendKeys(PropertiesFile.getPropertyValuebyKey("searchKeyword"));
		home.SearchBtn.click();
		
		ItemPage item = new ItemPage(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", item.SearchResult1);
		
		item.SearchResult1img.click();
		
		 String ItemNameIP = item.ItemName.getText();
		    System.out.println("ItemNameIP: "+ItemNameIP);
		    String ItemPriceIP = item.ItemPrice.getText();
		    System.out.println("ItemPriceIP: "+ItemPriceIP);
		    
		    String discountCode = item.DiscountCode.getText();
		    System.out.println("discountCode: "+discountCode);
		    String discountedPrice = item.DiscountedPrice.getText();
		    System.out.println("discountedPrice: "+discountedPrice);
		    
		    item.AddtoCartBtn.click();
		    
		    item.CheckoutBtn.click();
		    
		    CartPage cart = new CartPage(driver);
		    js.executeScript("arguments[0].scrollIntoView();", cart.PromocodeOrDiscountlink);
		    
		    boolean status = cart.GiftVoucherMsg.isEmpty();
		    
		    System.out.println("Status: " + status);
		    
		    if(!status) {
		    	
		    	cart.CloseDiscountSugg.click();
		    	cart.NoVoucherdialogClose.click();
		    	cart.PromocodeOrDiscountlink.click();
		    	
		    }
		    else {
		    	
		    cart.PromocodeOrDiscountlink.click();
		    
		    
		    }
		    
		    cart.PromocodeOrDiscountField.sendKeys(discountCode);
		    cart.PromocodeOrDiscountAddBtn.click();
		    
		    
		    wait.until(ExpectedConditions.visibilityOf(cart.PromocodeAddedMsg));
		    
		    Assert.assertTrue(cart.PromocodeAddedMsg.isDisplayed());
		    
		    js.executeScript("arguments[0].scrollIntoView();", cart.ItemLastPriceCP);
		    
		    String lastPrice = cart.ItemLastPriceCP.getText();
		    
		    Assert.assertEquals(discountedPrice, lastPrice);
		    cart.ItemMinusBtn.click();		    
		    wait.until(ExpectedConditions.visibilityOf(cart.RemoveGoodsBtn));
			cart.RemoveGoodsBtn.click();
		    
		    

	}
	
}
