
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.AppiumDriver;

@SuppressWarnings("unused")
public class HousingDemo {

	public AndroidDriver<MobileElement> driver;

	public static String device = "Android";
	public static String deviceName = "And-2";
	public static String platformVerion = "ANDROID";
	public static String platformName = "ANDROID";
	public static String app_Path = "C:\\Users\\admin\\Downloads\\Housing Real Estate Property_v10.4.2_apkpure.com.apk";

	@BeforeTest
	public void Open_Application() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("device", device);
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("platformVersion", platformVerion);
		cap.setCapability("platformName", platformName);
		cap.setCapability("app", app_Path);
		//URL url = new URL("http://127.0.0.1:4725/wd/hub");
	    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4725/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void SignUp_Page() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bengaluru']")).click();
		String City_Name = driver.findElement(By.id("com.locon.housing:id/home_screen_city_text")).getText();
		System.out.println("Selected City Name is " + City_Name);
		driver.findElement(By.id("com.locon.housing:id/home_screen_search_box")).click();
		driver.findElement(By.id("com.locon.housing:id/search_edit_box")).sendKeys("jp nagar");
		driver.findElement(By.xpath("//android.widget.TextView[@text='JP Nagar, Bangalore']")).click();
		driver.findElement(By.id("com.locon.housing:id/apply")).click();
		
		String Project_Count = driver.findElement(By.id("com.locon.housing:id/no_of_listings")).getText();

		System.out.println("Total No.Of Projects :" + Project_Count);
		List<MobileElement> ProjectNames = driver.findElements(By.id("com.locon.housing:id/title_text"));
		//Actions act = new Actions(driver);
		TouchAction act = new TouchAction(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		int initial_Count = 0;
		int Total_Count = ProjectNames.size();
		String project="My projects";
		boolean found_result = false;
		if(!found_result)
		{
			List<MobileElement> ProjectNames1 = driver.findElements(By.id("com.locon.housing:id/title_text"));
			int size =0;
			
			size = size+ProjectNames1.size();
			
			for(int i=0;i<size;i++)
			{
				Thread.sleep(3000);
				String s = ProjectNames1.get(i).getText();
				System.out.println(s);
				if(s.equals(project))
				{
					found_result = true;
					break;
				}
				else
				{
					driver.swipe(80, 40, 80, 20, 3000);
				}
			}
		}
		
		/*
		
		while (initial_Count != Total_Count) {
			initial_Count = Total_Count;
			Thread.sleep(3000);
			
			//act.press(0,0).moveTo(10, 10).release();
			//driver.performTouchAction(act);
			driver.swipe(80, 40, 80, 20, 3000);
			//act.moveToElement(ProjectNames.get(Total_Count - 1)).build().perform();
			
			//scrollObject.put("direction", "down");
			//scrollObject.put("element", ((RemoteWebElement)ProjectNames.get(Total_Count)).getId());
			//js.executeScript("mobile:scroll", scrollObject);
			ProjectNames = driver.findElements(By.id("com.locon.housing:id/title_text"));
			Thread.sleep(3000);
			Total_Count = ProjectNames.size();                                      //android.widget.RelativeLayout/android.widget.TextView
			System.out.println(Total_Count);
			
		}

		for (int i = 0; i < Total_Count; i++) {
			System.out.println(ProjectNames.get(i).getText());
		}*/
	}
	
	@AfterTest
	public void Close_App()
	{
		driver.quit();
	}
}
