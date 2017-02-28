import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Alibaba_SignUp_Page {
	WebDriver dr;
	
	@Test
	public void SignUp_flow()
	{
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.get("http://www.alibaba.com/");
		
		// Directly click on the JOIN FREE link:
		
		//dr.findElement(By.xpath("//span[@class='sc-hd-ms-login']/a[text()='Join Free']")).click();
		
		// Inside JOIN FREE link click:
		
		WebElement Option = dr.findElement(By.xpath("//span[@class='sc-hd-ms-login']/a[text()='Join Free']"));
		Actions act = new Actions(dr);
		act.moveToElement(Option).build().perform();
		//dr.findElement(By.xpath("//span[@class='sc-hd-ms-login']/a[text()='Join Free']"))
		
		
	}

}
