import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GmailTestCase {

	WebDriver driver;
	WebDriverWait wait;
	String Status = null;
	String Text1 = null;
	String password_Xpath = "//*[@id='Passwd']";
	String email_xpath = "//*[@id='Email']";
	String errormsg_Xpath = "//*[@id='errormsg_0_Email']";

	@BeforeClass
	public void Open_Browser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://gmail.com");
	}

	@Test(priority=1,dataProvider = "getDataEmail")
	public void SignUp(String email, String exp_result, String act_result, String result) throws InterruptedException {

		System.out.println("Test data :" + email);
		isLoginValidate(email_xpath, email);
		isVerify(errormsg_Xpath, exp_result);

		Xls_Reader xls = new Xls_Reader(
				"C:\\Users\\admin\\workspace\\Appium_Android\\testCaseExcel\\gmailUserCredential.xlsx");
		int row = xls.getCellRowNum("Sheet1", "Actual_Result", "");
		xls.setCellData("Sheet1", "Actual_Result", row, Text1);
		xls.setCellData("Sheet1", "Status", row, Status);

	}
	
	@Test(priority=2,dataProvider = "getDataPwds")
	public void PasswordValidation(String pwd, String exp_result, String act_result, String result) throws InterruptedException
	{
		isLoginValidate(password_Xpath, pwd);
		isVerify(errormsg_Xpath, exp_result);

		Xls_Reader xls = new Xls_Reader(
				"C:\\Users\\admin\\workspace\\Appium_Android\\testCaseExcel\\gmailUserCredential.xlsx");
		int row = xls.getCellRowNum("Sheet2", "Actual_Result", "");
		xls.setCellData("Sheet2", "Actual_Result", row, Text1);
		xls.setCellData("Sheet2", "Status", row, Status);
		
	}

	private void isVerify(String errormsg_Xpath, String exp_result) {

		Text1 = driver.findElement(By.xpath(errormsg_Xpath)).getText();
		System.out.println(Text1);
		if (Text1.contentEquals(exp_result))
			Status = "Pass";
		else
			Status = "Fail";

		// Assert.assertEquals(Text1, exp_result);

	}

	private void isLoginValidate(String email_xpath, String string) throws InterruptedException {

		driver.findElement(By.xpath(email_xpath)).clear();
		driver.findElement(By.xpath(email_xpath)).sendKeys(string);
		Thread.sleep(3000);
		driver.findElement(By.xpath(email_xpath)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@DataProvider
	public Object[][] getDataEmail() {
		Xls_Reader xls = new Xls_Reader(
				"C:\\Users\\admin\\workspace\\Appium_Android\\testCaseExcel\\gmailUserCredential.xlsx");
		int rows = xls.getRowCount("Sheet1");
		int colms = xls.getColumnCount("Sheet1");
		Object[][] data = new Object[rows - 1][colms];
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < colms; colNum++) {
				data[rowNum - 2][colNum] = xls.getCellData("Sheet1", colNum, rowNum);
			}
		}
		return data;

	}

	@DataProvider
	public Object[][] getDataPwds() {
		Xls_Reader xls = new Xls_Reader(
				"C:\\Users\\admin\\workspace\\Appium_Android\\testCaseExcel\\gmailUserCredential.xlsx");
		int rows = xls.getRowCount("Sheet2");
		int colms = xls.getColumnCount("Sheet2");
		Object[][] data = new Object[rows - 1][colms];
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < colms; colNum++) {
				data[rowNum - 2][colNum] = xls.getCellData("Sheet2", colNum, rowNum);
			}
		}
		return data;

	}

}
/*
 * // User password page:
 * 
 * for(int j=0; j<pwds.size(); j++) {
 * driver.findElement(By.xpath(password_Xpath)).clear(); System.out.println(
 * "Test cases possiblities for password :"+pwds.get(j));
 * isLoginValidate(password_Xpath, pwds.get(j));
 * 
 * }
 * 
 * Xls_Reader xls = new Xls_Reader(
 * "C:\\Users\\admin\\workspace\\Appium_Android\\testCaseExcel\\gmailUserCredential.xlsx"
 * );
 * 
 * List<String> emails = new ArrayList<>(); List<String> pwds = new
 * ArrayList<>();
 * 
 * //HashMap<String, String> maps = new HashMap<String, String>(); int
 * totalvalidation = xls.getRowCount("Sheet1");
 * 
 * for(int i=2; i<=totalvalidation; i++) { emails.add(xls.getCellData("Sheet1",
 * "Email", i)); pwds.add(xls.getCellData("Sheet1", "Password", i));
 * 
 * 
 * }
 * 
 * // User Email page validation untill valid email u can't go the password
 * page. String email_xpath = "//*[@id='Email']"; String password_Xpath
 * ="//*[@id='Passwd']"; for(int j=0; j<emails.size(); j++) {
 * driver.findElement(By.xpath(email_xpath)).clear(); System.out.println(
 * "Test cases possiblities for email:"+emails.get(j));
 * isLoginValidate(email_xpath, emails.get(j));
 * 
 * }
 * 
 * 
 */