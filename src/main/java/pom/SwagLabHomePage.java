package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SwagLabHomePage {
	
	@FindBy (xpath = "//span[@data-test='title']") private WebElement title;
	@FindBy (xpath = "//div[@class='inventory_item_name ']") private List<WebElement> productTitle;
	@FindBy (xpath = "//button[@class='btn btn_primary btn_small btn_inventory ']") private List<WebElement> addToCart;
	@FindBy (xpath = "//a[@class='shopping_cart_link']") private WebElement cart;
	@FindBy (xpath = "//button[text()='Remove']") private List<WebElement> removeOnHome;
	@FindBy (xpath = "//button[@id='react-burger-menu-btn']") private WebElement menu;
	@FindBy (xpath = "//div[@class='inventory_item_price']") private List<WebElement> productPrice;
	@FindBy (xpath = "//select[@class='product_sort_container']") private WebElement sort;
	@FindBy (xpath = "//a[@id='about_sidebar_link']") private WebElement about;
	@FindBy (xpath = "//a[@id='logout_sidebar_link']") private WebElement logout;
	
	public SwagLabHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	public void clickOnMenu() {
		menu.click();
	}
	public void clickOnLogout() {
		logout.click();
	}
	
	public void clickOnAbout() {
		about.click();
	}
	
	
	public void clickOnCart() {
		cart.click();
	}
	
	public void addToCart(int index) {
		addToCart.get(index).click();
	}
	
	public String addToCartText(int index) {
		return addToCart.get(index).getText();
	}
	
	public void multipleAddToCart(int index) {		
		for(WebElement product:addToCart) {
			addToCart.get(index).click();
		}		
	}
	
	public int total_remove() {
		return removeOnHome.size();
	}
	
	public boolean removeBtnIsDisplayed(int index) {
		return removeOnHome.get(index).isDisplayed();
	}
	
	public void clickOnRemove(int index) {
		removeOnHome.get(index).click();
	}
	
	public String product_title(int index) {
		return productTitle.get(index).getText();
	}
	
	public double productprize(int index) {
		String price=productPrice.get(index).getText().substring(1);
		return Double.parseDouble(price); 
	}
	
	public void selectSortType(String type) {
		Select select=new Select(sort);
		select.selectByVisibleText(type);
	}
	
	

}
