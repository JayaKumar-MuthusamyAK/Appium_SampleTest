import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GmailTestCase {
	
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void SignUp() throws InterruptedException {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get("http://gmail.com");
		
		Xls_Reader xls = new Xls_Reader("C:\\Users\\admin\\workspace\\Appium_Android\\testCaseExcel\\gmailUserCredential.xlsx");
		
		List<String> emails = new ArrayList<>();
		List<String> pwds = new ArrayList<>();
		
		//HashMap<String, String> maps = new HashMap<String, String>();
		int totalvalidation = xls.getRowCount("Sheet1");
		
		for(int i=2; i< totalvalidation; i++)
		{
			emails.add(xls.getCellData("Sheet1", "Email", i));
			pwds.add(xls.getCellData("Sheet1", "Password", i));
			
			
		}
		
		// User Email page validation 
		String email_xpath = "//*[@id='Email']";
		String password_Xpath ="//*[@id='Passwd']";
		for(int j=0; j<emails.size(); j++)
		{
			isLoginValidate(email_xpath, emails.get(j));
		}
		
		
		
		//driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys("bullet07@");
		//driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(Keys.ENTER);
		
		

	}
	private void isLoginValidate(String email_xpath, String string) {
		
		driver.findElement(By.xpath(email_xpath)).sendKeys("jakay507@gmail.com");
		
		driver.findElement(By.xpath(email_xpath)).sendKeys(Keys.ENTER);
	}
}
