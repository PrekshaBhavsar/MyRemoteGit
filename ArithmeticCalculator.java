package program.jav.calculator;

import java.util.Scanner;

class calculator{			 //class
	private double add; // variable
	private double sub;
	private double mul;
	private double div;
	private double b;
	private double a;
	//Constructor
	calculator(double a,double b){
		
		this.a = a;
		this.b = b;
		System.out.println("Calculation........");
	}
//-------------------------------------------------------
	public double Add() {
		
		add = a + b;
		//System.out.println("Addition of two numbers is "+add);
		return add;
	}
	public double subtraction() {
		if(a>b) {
			sub = a - b;
		}
		else {
			sub = b - a;
		}
		//System.out.println("subtraction of two numbers is "+sub);
		return sub;
		
	}
	public double multiplication() {
		mul = a * b;
		//System.out.println("multiplication of two numbers is "+mul);
		return mul;
	}
	public double division() {
		div = a / b;
		//System.out.println("division of two numbers is "+div);
		return div;
	}
//-------------------------------------------------------
}	
	
public class ArithmeticCalculator {

	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);		
		
	    System.out.print("Enter the 1 st number :");
	    double num1 = S.nextDouble();
		//System.out.println(num1);
		
		System.out.print("Enter the 2 nd number :");
		double num2 = S.nextDouble();
		//System.out.println(num2);
		
		calculator C = new calculator(num1,num2);
		int sum = (int) C.Add(); //Explicit type cast double -> int
		int sub = (int) C.subtraction(); //Explicit type cast double -> int
		double mul = C.multiplication();
		double div = C.division();
		
		System.out.println("The sum of two number : "+sum);
		System.out.println("The subtraction of two number : "+sub);
		System.out.println("The multiplication of two number : "+mul);
		System.out.println("The division of two number : "+div);

	}



}


