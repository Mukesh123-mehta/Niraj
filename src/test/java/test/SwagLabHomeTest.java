package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabAboutPage;
import pom.SwagLabCartPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

public class SwagLabHomeTest {
	WebDriver driver;
	@BeforeMethod
	public void launch_browser() {
		driver=Browser.launch("https://www.saucedemo.com");
		SwagLabLoginPage swagLabLoginPage=new SwagLabLoginPage(driver);
		swagLabLoginPage.inputusername("standard_user");
		swagLabLoginPage.inputpass("secret_sauce");
		swagLabLoginPage.loginbtn();
	}
	@AfterMethod
	public void close_browser() {
		driver.quit();
	}
	
	@Test
	public void UserIsAbleToAceesAboutPage() {
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		SwagLabAboutPage swagLabAboutPage=new SwagLabAboutPage(driver);
		swagLabHomePage.clickOnMenu();
		swagLabHomePage.clickOnAbout();
		String heading=swagLabAboutPage.headingOnabout();
		Assert.assertEquals(heading,"The world relies on your code. Test on thousands of different device, browser, and OS configurations–anywhere, any time.");
	}
	@Test
	public void UserIsAbleToClickCart() {
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		SwagLabCartPage swagLabCartPage=new SwagLabCartPage(driver);
		swagLabHomePage.clickOnCart();
		String title=swagLabCartPage.cart_title();
		Assert.assertEquals(title, "Your Cart");
	}
	@Test
	public void UserIsAbleToAddProduct() {
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		swagLabHomePage.addToCart(0);
		Assert.assertEquals(true, swagLabHomePage.removeBtnIsDisplayed(0));		
	}
	@Test
	public void UserIsAbleToAddMultipleProduct() {
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		for(int i=0;i<=5;i++) {
			swagLabHomePage.multipleAddToCart(i);
			break;
		}
		Assert.assertEquals(swagLabHomePage.total_remove(), 6);		
	}
	
	@Test
	public void UserIsAbleToRemoveFromHome() {
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		swagLabHomePage.addToCart(0);
		swagLabHomePage.clickOnRemove(0);
		Assert.assertEquals(swagLabHomePage.addToCartText(0), "Add to cart");
	}
	@Test
	public void CheckUserIsAbleToSortProductsAtoZ() {
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		String first_product=swagLabHomePage.product_title(0);
		String last_product=swagLabHomePage.product_title(5);
		swagLabHomePage.selectSortType("Name (A to Z)");
		
		Assert.assertEquals(first_product,swagLabHomePage.product_title(0));
		Assert.assertEquals(last_product, swagLabHomePage.product_title(5));
	}
	
	@Test
	public void CheckUserIsAbleToSortProductsZtoA() {
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		String first_product=swagLabHomePage.product_title(0);
		String last_product=swagLabHomePage.product_title(5);
		swagLabHomePage.selectSortType("Name (Z to A)");
		
		Assert.assertEquals(first_product,swagLabHomePage.product_title(5));
		Assert.assertEquals(last_product, swagLabHomePage.product_title(0));
	}
	
	@Test
	public void CheckUserIsAbleToSortProductsHightoLow() {
		SwagLabHomePage swagLabHomePage =new SwagLabHomePage(driver);
		
		swagLabHomePage.selectSortType("Price (high to low)");
		Assert.assertTrue(swagLabHomePage.productprize(0) >= swagLabHomePage.productprize(1));
		Assert.assertTrue(swagLabHomePage.productprize(1) >= swagLabHomePage.productprize(2));
		Assert.assertTrue(swagLabHomePage.productprize(2) >= swagLabHomePage.productprize(3));
		Assert.assertTrue(swagLabHomePage.productprize(3) >= swagLabHomePage.productprize(4));
		Assert.assertTrue(swagLabHomePage.productprize(4) >= swagLabHomePage.productprize(5));
	}
	
	@Test
	public void CheckUserIsAbleToSortProductsLowtoHigh() {
		SwagLabHomePage swagLabHomePage =new SwagLabHomePage(driver);
		
		swagLabHomePage.selectSortType("Price (low to high)");
		Assert.assertTrue(swagLabHomePage.productprize(0) <= swagLabHomePage.productprize(1));
		Assert.assertTrue(swagLabHomePage.productprize(1) <= swagLabHomePage.productprize(2));
		Assert.assertTrue(swagLabHomePage.productprize(2) <= swagLabHomePage.productprize(3));
		Assert.assertTrue(swagLabHomePage.productprize(3) <= swagLabHomePage.productprize(4));
		Assert.assertTrue(swagLabHomePage.productprize(4) <= swagLabHomePage.productprize(5));
	}
	
	@Test
	public void CheckTheCorrectProductAddedInCartOrNot() throws InterruptedException {
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		String product1=swagLabHomePage.product_title(0);
		String product2=swagLabHomePage.product_title(1);
		
		swagLabHomePage.addToCart(0);
		swagLabHomePage.addToCart(0);
		swagLabHomePage.clickOnCart();
		
		SwagLabCartPage swagLabCartPage=new SwagLabCartPage(driver);
		Assert.assertEquals(product1,swagLabCartPage.cartProductTitle(0));
		Assert.assertEquals(product2,swagLabCartPage.cartProductTitle(1));
		
		
	}

	
	
	
}
	
