package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

public class SwagLabLogoutTest {
	
	WebDriver driver;
	@BeforeMethod
	public void launch_browser() {
		driver=Browser.launch("https://www.saucedemo.com");
	}
	@AfterMethod
	public void close_browser() {
		driver.quit();
	}
	@Test
	public void UserIsAbleToLogout() {
		SwagLabLoginPage swagLabLoginPage=new SwagLabLoginPage(driver);
		swagLabLoginPage.inputusername("standard_user");
		swagLabLoginPage.inputpass("secret_sauce");
		swagLabLoginPage.loginbtn();
		
		SwagLabHomePage swagLabHomePage=new SwagLabHomePage(driver);
		swagLabHomePage.clickOnMenu();
		swagLabHomePage.clickOnLogout();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/" );
		
	}

}
