package com.core;

import static com.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	
	
	@AfterMethod
	public void tearDown(ITestResult testResult) throws InterruptedException, IOException {
		Date date = new Date();
		
		File screen = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("target" + File.separator + testResult.getName()+"_"+date+".jpg"));
		
		DriverFactory.killDriver();
	}

}
