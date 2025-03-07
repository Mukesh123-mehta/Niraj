package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabAboutPage {
	
	@FindBy (xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1mz1i0z']") private WebElement headingOnAbout;

	
	public SwagLabAboutPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String headingOnabout() {
		return headingOnAbout.getText();
	}
}
