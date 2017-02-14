package com.commonsite.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon_Test

{
	public WebDriver dr = null;
	String Expect_Title= "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
	String User_Keywords="shirts for men";
	
	@Test
	public void Project_AddCartValidation()
	{
		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		dr.get("https://www.amazon.com/ref=nav_logo");
		
		System.out.println("Title of the page :"+dr.getTitle());
		
		// Verity Title Using by assert class
		
		String Actual_Title= dr.getTitle();
		Assert.assertEquals(Actual_Title, Expect_Title);
		
		
		dr.findElement(By.className("redir-overlay-close")).click();
		
		dr.findElement(By.id("twotabsearchtextbox")).sendKeys("Shirt");
		
		//div[@id='suggestions-template']/suggestions
		List<WebElement> List_Of_Suggest = dr.findElements(By.xpath("//div[@id='suggestions-template']/div/div[@class='s-suggestion']"));
		/*for(int i=0; i<List_Of_Suggest.size();i++)
		{
			System.out.println(List_Of_Suggest.get(i).getText());
			
		}
		*/
		
		int i=0;
		while(i<List_Of_Suggest.size())
		{
			if(List_Of_Suggest.get(i).getText().equalsIgnoreCase(User_Keywords))
			{
				List_Of_Suggest.get(i).click();
				break;
			}
				i++;
		}
		
		System.out.println("Product Count"+dr.findElement(By.xpath("//*[@id='s-result-count']")).getText());
		
		
		String Project_Name1 = "Dream USA Men's Casual 3/4 Sleeve Baseball Tshirt Raglan Jersey Shirt";
		String Project_Name2 ="PAUL JONES Mens Long Sleeves Slim Fit Dress Shirts";
		List<WebElement>List_of_Project= dr.findElements(By.xpath(".//ul[@id='s-results-list-atf']/li/div/div[3]/div[1]/a"));
		for(int j=0; j<List_of_Project.size();j++)
		{
			System.out.println(List_of_Project.get(j).getText());
			
		}
		
		int check=0;
		
		Actions act = new Actions(dr);
	    while(check<List_of_Project.size())
	    {
	    	if(List_of_Project.get(check).getText().equals(Project_Name1))
	    	{
	    		act.moveToElement(List_of_Project.get(check)).build().perform();
	    		List_of_Project.get(check).click();
	    		break;
	    	}
	    	check++;
	    }
	    
	 // Check without select the Quantity user can't add the project to wishlist.
	    
	    String TagName = dr.findElement(By.xpath("//*[@id='add-to-cart-button']")).getAttribute("style");
	    System.out.println(TagName);
	  
	    WebElement Dropdown_List = dr.findElement(By.id("native_dropdown_selected_size_name"));
	    Select Quantity_DropDown = new Select(Dropdown_List);
	    WebElement element = Quantity_DropDown.getFirstSelectedOption();
	    String Option = element.getText();
	    //System.out.println(Quantity_DropDown.getOptions());
	    
	    System.out.println("*********************************************************************");
	    
	    if(Option.equals("select"))
	    {
	    		Assert.assertEquals(TagName, "cursor: not-allowed;");
	    }
	    else
	    {
	    	Quantity_DropDown.selectByIndex(1);
	    }
	    
	    Assert.assertFalse(dr.findElements(By.xpath("//*[@id='add-to-cart-button'][@style='cursor: not-allowed;']")).size()!=0, "Now Add Cart button is Enabled.");
	    
	}
}
