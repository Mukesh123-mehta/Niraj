package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabCartPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

public class SwagLabCartTest {
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
	public void UserIsAbleToRemoveFromCart() {
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		swagLabHomePage.addToCart(0);
		swagLabHomePage.addToCart(1);
		swagLabHomePage.addToCart(2);
		swagLabHomePage.clickOnCart();
		
		SwagLabCartPage swagLabCartPage=new SwagLabCartPage(driver);
		swagLabCartPage.clickOnRemoveCart(0);	
		Assert.assertEquals(swagLabCartPage.totalProductsInCart(),2);
	}

}
