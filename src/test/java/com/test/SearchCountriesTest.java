package com.test;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.core.SpreedSheetData;
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
			{ "Italy", "Italia" }
		};	
	}
	
	@Test(dataProvider = "countriesExcel")
	public void testSearchCountriesExcel(String searchCountry, String expectedCountry) {				
		detailPage = mainPage.searchCountry(searchCountry);
		assertEquals(detailPage.getTitleCountry(), expectedCountry);		
	}
	
	@DataProvider(name = "countriesExcel")
	public Object[][] dataProviderCountriesExcel(){
		Object[][] testData = SpreedSheetData.readExcelData("Paises"
				, "src" + File.separator + "test" + File.separator + "resources" + File.separator+ "paises.xls"
				, "Dados");
		return testData;
	}
	
	
}
