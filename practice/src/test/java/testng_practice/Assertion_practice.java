package testng_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion_practice {

	@Test
	public void testAssertions() {
		String str1 = new String("TestNG");
		String str2 = new String("TestNG");
		String str3 = null;
		String str4 = "TestNG";
		String str5 = "TestNG";
		String str6 = new String("Not_TestNG");
		int val1 = 5;
		int val2 = 6;
		Assert.assertEquals(str1, str2);
		System.out.println("Equals assertions is successful");
		Assert.assertNotEquals(str1, str6);
		System.out.println("Not equals assertion is successful");
		Assert.assertTrue(val1<val2);
		System.out.println("True assertion is successful");
		Assert.assertFalse(val1>val2);
		System.out.println("False assertion is successful");
		Assert.assertNotNull(str1);
		System.out.println("Not null assertion is successful");
		Assert.assertNull(str3);
		Assert.assertSame(str4, str5);
		System.out.println("Same Assertion is Successful");
		Assert.assertNotSame(str1, str3);
		System.out.println("Not Same Assertion is successful");
	}
}
