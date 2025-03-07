package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabCartPage;
import pom.SwagLabCheckoutPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;
import pom.SwagLabYourInfoPage;

public class SwagLabCheckOutTest {
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
	public void verifycostCalculationOnCheckout() {		
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		swagLabHomePage.addToCart(0);
		swagLabHomePage.addToCart(1);
		swagLabHomePage.clickOnCart();
		SwagLabCartPage swagLabCartPage=new SwagLabCartPage(driver);
		swagLabCartPage.clickOnCheckOut();
		
		SwagLabYourInfoPage swagLabYourInfoPage=new SwagLabYourInfoPage(driver);
		swagLabYourInfoPage.firstname("Kunal");
		swagLabYourInfoPage.lastname("Sarode");
		swagLabYourInfoPage.zipcode("454775");
		swagLabYourInfoPage.clickOnContinue();
		
		SwagLabCheckoutPage swagLabCheckoutPage=new SwagLabCheckoutPage(driver);
		double ItemPrize1=swagLabCheckoutPage.cartProductPrize(0);
		double ItemPrize2=swagLabCheckoutPage.cartProductPrize(1);
		double expectedItemTotal=ItemPrize1+ItemPrize2;
		double expectedTotal=expectedItemTotal+swagLabCheckoutPage.tax();
		
		Assert.assertEquals(swagLabCheckoutPage.cartProductItemTotal(), expectedItemTotal);
		Assert.assertEquals(swagLabCheckoutPage.carttotal(), expectedTotal);
	}
	
	@Test
	public void checkIfUserIsAbleToPlaceOrder() {
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		swagLabHomePage.addToCart(0);
		swagLabHomePage.addToCart(1);
		swagLabHomePage.clickOnCart();
		SwagLabCartPage swagLabCartPage=new SwagLabCartPage(driver);
		swagLabCartPage.clickOnCheckOut();
		
		SwagLabYourInfoPage swagLabYourInfoPage=new SwagLabYourInfoPage(driver);
		swagLabYourInfoPage.firstname("Kunal");
		swagLabYourInfoPage.lastname("Sarode");
		swagLabYourInfoPage.zipcode("454775");
		swagLabYourInfoPage.clickOnContinue();
		
		SwagLabCheckoutPage swagLabCheckoutPage =new SwagLabCheckoutPage(driver);
		swagLabCheckoutPage.clickOnFinishBtn();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");		
	}
	
	@Test 
	public void checkUserGoToHomePageAfterClickingBackToHome() {
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		swagLabHomePage.addToCart(0);
		swagLabHomePage.addToCart(1);
		swagLabHomePage.clickOnCart();
		SwagLabCartPage swagLabCartPage=new SwagLabCartPage(driver);
		swagLabCartPage.clickOnCheckOut();
		
		SwagLabYourInfoPage swagLabYourInfoPage=new SwagLabYourInfoPage(driver);
		swagLabYourInfoPage.firstname("Kunal");
		swagLabYourInfoPage.lastname("Sarode");
		swagLabYourInfoPage.zipcode("454775");
		swagLabYourInfoPage.clickOnContinue();
		
		SwagLabCheckoutPage swagLabCheckoutPage =new SwagLabCheckoutPage(driver);
		swagLabCheckoutPage.clickOnFinishBtn();
		swagLabCheckoutPage.clickOnBackToHome();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
	}
}
