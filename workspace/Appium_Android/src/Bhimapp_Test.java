import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Bhimapp_Test {

	//C:\Users\admin\Downloads\Guide for BHIM App UPI_v1.0.3_apkpure.com.apk
	
	public AndroidDriver<MobileElement> driver;

	public static String device = "Android";
	public static String deviceName = "And-2";
	public static String platformVerion = "ANDROID";
	public static String platformName = "ANDROID";
	public static String app_Path = "C:\\Users\\admin\\Downloads\\Guide for BHIM App UPI_v1.0.3_apkpure.com.apk";
	
	
	@BeforeTest
	public void Start() throws MalformedURLException {
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
	public void Open_App()
	{
		driver.findElement(By.id("com.leonard.moneychangingtipsinindia:id/btnselect")).click();
	}
	
	

}
