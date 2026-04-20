package testng_practice;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="testData", parallel = true)
	public Object[][] dataprov(){
		return new Object[][]{{"Selenium"},{"TestNG"},{"Automation"}};
	}
	@DataProvider(name="Demo", parallel = true)
	public Object[][] demoBlazecredentials(){
		return new Object[][] {
			{"Admin", "1234"},
			{"check", "admin"},
			{"Admin", "admin"}
		};
	}
}
