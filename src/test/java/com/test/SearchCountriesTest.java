package com.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.page.DetailPage;
import com.page.MainPage;

public class SearchCountriesTest extends BaseTest {
	
	private DetailPage detailPage;
	private MainPage mainPage;
	

	@BeforeMethod
	public void beforeMethod() {
		mainPage = new MainPage();
		mainPage.open();
	}
	
	@Test(dataProvider = "countriesList")
	public void testSearchCountries(String searchCountry, String expectedCountry) {				
		detailPage = mainPage.searchCountry(searchCountry);
		assertEquals(detailPage.getTitleCountry(), expectedCountry);		
	}
	
	@DataProvider(name = "countriesList")
	public Object[][] dataProviderCountriesList(){
		return new Object[][] { 
			{ "India", "India" }, 
			{ "Brazil", "Brazil" }, 
			{ "Argentina", "Argentina" },
			{ "Italy", "Italy" }
		};	
	}		
}
