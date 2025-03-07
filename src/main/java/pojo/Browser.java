package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	public static WebDriver launch(String url) {
		System.getProperty("webdrive.chrome.driver","C:\\Selenium\\chromedriver-win64\\chromedriver-win64");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		return driver;
	}
}
