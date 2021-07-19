package testNGExample;

import org.testng.annotations.Test;

public class TestCase2 extends BaseClass{

	@Test
	public void LoanTest2() {

		System.out.println("Inside Loan Test2");
	}
	@Test(groups= {"Sanity"})
	public void InsuranceTest() {

		System.out.println("Inside Insurance Test");
	}

}
