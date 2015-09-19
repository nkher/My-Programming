
public class SwapWithoutTemp {

	public static void main(String[] args) {
			
		int num1=10;
		int num2=20;
		
		System.out.println("Before Swap - num1 is " + num1 + " num2 is " + num2);
		//Swapping the two
		num1=num1+num2;//num1=30
		num2=num1-num2;//num2=10
		num1=num1-num2;//num1=20
		System.out.println("After Swap - num1 is " + num1 + " num2 is " + num2);
	}

}
