package Basic;

public class Typecast {

	public static void main(String[] args) {
		//Implicit typecast
		
		int i = 10;
		long j = i; //implicit type cast
		
		System.out.println("Implicit conversion Example");
		System.out.println("Value of i "+i+" and Value of j "+j);
		
		//Explicit typecast
		float x = 12.56f;
		int y = (int)x;

		System.out.println("Explicit conversion Example");
		System.out.println("Value of x "+x+" and Value of y "+y);
	}

}
