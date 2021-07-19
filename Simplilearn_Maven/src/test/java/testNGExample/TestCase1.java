package testNGExample;


import org.testng.annotations.Test;


public class TestCase1 extends BaseClass {

	@Test
	public void LoanTest() {

		System.out.println("Inside Loan Test");
	}
	@Test(groups= {"Sanity"})
	public void LoanTest1() {

		System.out.println("Inside Loan Test1");
	}

	@Test(enabled=true)
	public void CreditCardTest() {

		System.out.println("Inside CC Test");

	}

}
