package com.hybridframework_Selenium.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.hybridframework_Selenium.testScripts.Keywords;
import com.hybridframework_Selenium.testUtils.TestUtils;

public class TC005_Flight_SearchListingTestCase {
	
	@Test
	public void Flight_SearchListingTestCase() throws Exception{
		
		if(!TestUtils.isTestcasesExecutable("FlightSearchlistTestCase", Keywords.xls)){
			throw new SkipException("User set this test case run mode is No");
		}
		Keywords k = Keywords.getInstance();
		k.executeKeywords("FlightSearchlistTestCase",null);
		
	}

}
