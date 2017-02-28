import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

public class AppTest {

	 // Make sure :
	// emulator -> developer mode should be on.
	// Adb device should be started.
	// Appium should be started.
	
	public WebDriver driver;
	public DesiredCapabilities cap;
	
	String mobile_No ="6666655555";
	String otp_password ="666666";
	
	String Partner_Xpath = "com.housingman.android.housingman_android:id/association_partnerButton";
	String Individual_Xpath ="com.housingman.android.housingman_android:id/partnerDetail_partnerType_individual";
	@BeforeTest
	public void Launch_Application() throws MalformedURLException
	{
		//File app = new File("C:\\Users\\admin\\Downloads\\app-debug_(3).apk");
		String appPath = "C:\\Users\\admin\\Downloads\\app-debug (7).apk";
		cap = new DesiredCapabilities();
		//cap.setCapability("BROWSER_NAME", "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "ANDROID");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "And-2");
		cap.setCapability("app", appPath);
		driver =  new RemoteWebDriver(new URL("http://127.0.0.1:4725/wd/hub"),cap);
	
	}
	
	@Test
	public void SignUp() throws InterruptedException
	 {
		
		
		driver.findElement(By.id("com.housingman.android.housingman_android:id/next")).click();
		driver.findElement(By.id("com.housingman.android.housingman_android:id/next")).click();
		driver.findElement(By.id("com.housingman.android.housingman_android:id/done")).click();
		
		// Enter the mobile number :
		System.out.println("Verify the mobile number page Label name :"+driver.findElement(By.id("com.housingman.android.housingman_android:id/loginTitle")).getText());
		driver.findElement(By.id("com.housingman.android.housingman_android:id/loginEditText")).sendKeys(mobile_No);
		
		driver.findElement(By.id("com.housingman.android.housingman_android:id/proceedButton")).click();
		
		// Verify the Mobile number :
		String Text1 = driver.findElement(By.id("com.housingman.android.housingman_android:id/otpStatus")).getText();
		String Text2 = driver.findElement(By.id("com.housingman.android.housingman_android:id/loginTitle")).getText();
		
		System.out.println("Verify OTP sent or Not :"+Text1);
		System.out.println("OTP label form :"+Text2);
		
		driver.findElement(By.id("com.housingman.android.housingman_android:id/loginEditText")).sendKeys(otp_password);
		driver.findElement(By.id("com.housingman.android.housingman_android:id/proceedButton")).click();
		
		// Sign up Page -> User basic registration:
		
		Thread.sleep(5000);
		
		if(driver.findElements(By.xpath("//android.widget.TextView[@text='HousingMan']")).size()==0)
		{
		String Text3 = driver.findElement(By.id("com.housingman.android.housingman_android:id/association_partnerButton")).getText();
		String Text4 = driver.findElement(By.id("com.housingman.android.housingman_android:id/association_builderButton")).getText();
		
		//driver.findElement(By.id("com.housingman.android.housingman_android:id/association_builderButton")).isSelected();
		
		//com.housingman.android.housingman_android
		// com.housingman.android.housingman_android
		
		System.out.println("Business fields radio button names are: "+Text3+","+Text4);
		
		Thread.sleep(3000);
		String Text5 = driver.findElement(By.id("com.housingman.android.housingman_android:id/partnerDetail_partnerType_individual")).getText();
		String Text6 = driver.findElement(By.id("com.housingman.android.housingman_android:id/partnerDetail_partnerType_organisation")).getText();
		
		
		System.out.println("Business fields radio button names are: "+Text5+","+Text6);
		
		System.out.println("**********************CHECKING FOR RADIO BUTTON SELECTION****************");
		
		isSelectedRadioButtonValidation(Partner_Xpath, Text3, Text4);
		isSelectedRadioButtonValidation(Individual_Xpath, Text5, Text6);
		
		
		// Submit the second step:
		
		driver.findElement(By.id("com.housingman.android.housingman_android:id/signUpProceedButton")).click();
		
		// Thrid Steps:
		
		driver.findElement(By.id("com.housingman.android.housingman_android:id/firstName")).sendKeys("Snehith");
		driver.findElement(By.id("com.housingman.android.housingman_android:id/email")).sendKeys("snehith@yopmail.com");
		driver.findElement(By.id("com.housingman.android.housingman_android:id/locality")).click();
		
		Thread.sleep(5000);
		//Search locaility name:
		driver.findElement(By.id("com.housingman.android.housingman_android:id/locality_search_text")).sendKeys("jp nag");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='JP Nagar']")).click();
		
		driver.findElement(By.id("com.housingman.android.housingman_android:id/address1")).sendKeys("JP nagar, 9_th Phase, Bangalore - 560011");
		
		//driver.findElement(By.id("com.housingman.android.housingman_android:id/userPhoto")).click();
		driver.findElement(By.id("com.housingman.android.housingman_android:id/userPhoto")).sendKeys("C:\\Users\\admin\\Downloads\\_logo (6).jpg");
		
		
		driver.findElement(By.id("com.housingman.android.housingman_android:id/signUpProceedButton")).click();
		
		//driver.quit();
		
		/*
		 if(!driver.findElement(By.id("com.housingman.android.housingman_android:id/partnerDetail_partnerType_individual")).isSelected())
			System.out.println("Channel Partner Radio button is selected :"+Text3);
		else 
			System.out.println("Builder is selected :"+Text4);
			
		 * File app= new File("apk-file-path");
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("deviceName", "your-device-name");
		capabilities.setCapability("platformVersion", "platform-version");
		capabilities.setCapability("platformName", "platform-name");
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.findElement(By.id("username-element")).sendKeys("username");
		driver.findElement(By.id("password-element")).sendKeys("password");
		driver.findElement(By.id("password-element ")).click();
		driver.quit();
		
		/*
		DesiredCapabilities Cap = new DesiredCapabilities();
		Cap.setCapability("BROWSER_NAME", "Android");
		Cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		//Cap.setCapability(MobileCapabilityType.APP, "com.android.calculator");
		Cap.setCapability(MobileCapabilityType.DEVICE_NAME, "And-2");
		
		String appPath = "C:\\Users\\admin\\Downloads\\app-debug_(3).apk";
		Cap.setCapability("app", appPath );
		
		WebDriver driver =  new RemoteWebDriver(new URL("http://127.0.0.1:4725/wd/hub"),Cap);
		*/
		}
		else
		{
			System.out.println("Already Sign UP.");
			
		}
	}

	public void isSelectedRadioButtonValidation(String xpath, String text1, String text2) {
		if(!driver.findElement(By.id(xpath)).isSelected())
			System.out.println("Channel Partner Radio button is selected :"+text1);
		else 
			System.out.println("Builder is selected :"+text2);
		
	}
	
}
