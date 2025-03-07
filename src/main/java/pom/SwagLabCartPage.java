package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCartPage {
	@FindBy (xpath = "//span[@class='title']") private WebElement cartTitle;
	@FindBy (xpath = "//button[@class='btn btn_secondary btn_small cart_button']") private List<WebElement> cartRemove;
	@FindBy (xpath = "//div[@class='cart_item_label']") private List<WebElement> cartProducts;
	@FindBy (xpath = "//div[@data-test='inventory-item-name']") private List<WebElement> productTitleOnCart;
	@FindBy (xpath = "//button[@id='checkout']") private WebElement checkoutBtn;
	public SwagLabCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String cart_title() {
		return cartTitle.getText();
	}
	
	public void clickOnRemoveCart(int index) {
		cartRemove.get(index).click();
	}
	
	public int totalProductsInCart() {
		return cartProducts.size();
	}
	public String cartProductTitle(int index) {
		return productTitleOnCart.get(index).getText();
	}
	
	public void clickOnCheckOut() {
		checkoutBtn.click();
	}

}
