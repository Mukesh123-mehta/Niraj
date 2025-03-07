package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabYourInfoPage {
	@FindBy (xpath = "//input[@id='first-name']") private WebElement firstname;
	@FindBy (xpath = "//input[@id='last-name']") private WebElement lastname;
	@FindBy (xpath = "//input[@id='postal-code']") private WebElement zipcode;
	@FindBy (xpath = "//button[@id='cancel']") private WebElement cancel;
	@FindBy (xpath = "//input[@id='continue']") private WebElement continuePage;
	
	public SwagLabYourInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void firstname(String name) {
		firstname.sendKeys(name);
	}
	
	public void lastname(String name) {
		lastname.sendKeys(name);
	}
	
	public void zipcode(String code) {
		zipcode.sendKeys(code);
	}
	
	public void clickOnContinue() {
		continuePage.click();
	}
	
	public void clickOnCancel() {
		cancel.click();
	}
}
