package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.GlobalProperty;

public class MainPage {
	
	public MainPage open() {
		getDriver().get(GlobalProperty.getProperty("webdriver.url"));
		return this;
	}
	
	public DetailPage searchCountry(String country) {
		
		WebElement tfSearch = getDriver().findElement(By.xpath("//input[@name='search']"));
		tfSearch.sendKeys(country);
		
		WebElement btnSearch = getDriver().findElement(By.xpath("//button[.='Search']"));
		btnSearch.click();
		
		return new DetailPage();
	}

}
