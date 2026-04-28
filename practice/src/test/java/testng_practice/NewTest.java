package testng_practice;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

 

public class NewTest {
	@BeforeTest
	public void start(){
		System.out.println("Before Test");
	}
	@AfterTest
	public void end(){
		System.out.println("After Test");
	}
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before Method");
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("After Method");
	}
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before Class");
	}
	@AfterClass
	public void afterClass(){
		System.out.println("After Class");
	}
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void afterSuite(){
		System.out.println("After Suite");
	}
	
  @Test
  public void loginTest() {
	  System.out.println("Login at test");
  }
  @Test
  public void logOutTest() {
	  System.out.println("Logout at test");
  }
  
  
  
  
}


