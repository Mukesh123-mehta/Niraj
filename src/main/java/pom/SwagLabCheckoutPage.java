package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutPage {
	@FindBy (xpath = "//div[@class='cart_item']") private List<WebElement> products;
	@FindBy (xpath = "//div[@class='inventory_item_name']") private List<WebElement> productName;
	@FindBy (xpath = "//div[@class='inventory_item_price']") private List<WebElement> productPrize;
	@FindBy (xpath = "//div[@data-test='subtotal-label']") private WebElement itemTotal;
	@FindBy (xpath = "//div[@class='summary_tax_label']") private WebElement tax;
	@FindBy (xpath = "//div[@class='summary_total_label']") private WebElement total;
	@FindBy (xpath = "//button[@id='cancel']") private WebElement cancel_btn;
	@FindBy (xpath = "//button[@id='finish']") private WebElement finish_btn;
	@FindBy (xpath = "//button[@id='back-to-products']") private WebElement backToHome;
	public SwagLabCheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int countOfTotalProducts() {
		return products.size();
	}
	
	public String cartProductName(int index) {
		return productName.get(index).getText();
	}
	
	public double cartProductPrize(int index) {
		String prize=productPrize.get(index).getText().substring(1);
		return Double.parseDouble(prize);
	}
	
	public double cartProductItemTotal() {
		String total=itemTotal.getText().substring(13);
		return Double.parseDouble(total);
	}
	
	public double tax() {
		String cartTax=tax.getText().substring(6);
		return Double.parseDouble(cartTax);
	}
	
	public double carttotal() {
		String cartTotal=total.getText().substring(8);
		return Double.parseDouble(cartTotal);
	}
	
	public void clickOnFinishBtn() {
		finish_btn.click();
	}
	
	public void clickOnCancelBtn() {
		cancel_btn.click();
	}
	
	public void clickOnBackToHome() {
		backToHome.click();
	}
	
	
	
}
