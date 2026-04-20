package testng_practice;

import org.testng.annotations.Test;

public class DependsOnGroupsExample {
	@Test(groups="groupA")
	public void testMethod1frogroupA() {
		System.out.println("Running test method1 of groupA");
	}
	
	@Test(groups="groupA")
	public void testMethod2forgroupA() {
		System.out.println("Running test method2 of groupA");
	}
	
	@Test(groups="groupB")
	public void testMethodforGroupB() {
		System.out.println("Running test method1 of groupB");
	}
	
	@Test(groups="groupB")
	public void testMethod2forGroupB() {
		System.out.println("Running test method1 of groupB");
	}
	
	@Test(dependsOnGroups="groupA")
	public void testMethod1() {
		System.out.println("Running the dependent test");
	}
	

}
