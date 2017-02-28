import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Linked_InWebSite {
	
	public WebDriver dr;
	String UserMail="jayakumarcse07@gmail.com";
	String Password = "bullet07@";
	
	@BeforeTest
	public void Open_Browser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\commonvalidator\\chromedriver1.exe");
		
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		dr.get("http://www.linkedin.com/");
		
	}
	
	@Test
	public void LoginLinkedIn_Page()
	{
		dr.findElement(By.id("login-email")).sendKeys(UserMail);
		dr.findElement(By.id("login-password")).sendKeys(Password);
		System.out.println(Password);
		dr.findElement(By.id("login-submit")).submit();
		//dr.navigate().to("");
	}

}
