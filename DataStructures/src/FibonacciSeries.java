import java.util.Scanner;

public class FibonacciSeries {

	private int a;
	
	public static void add(){
		System.out.println();
	}
	
	public void GenerateFibonacciSeries(int range){
		
		int previous,next,sum,n;
		previous=0;
		next=1;
		for (n=1;n<=range;n++){
			System.out.println(previous);
			sum=previous+next;//2, 3
			previous=next;//1, 2
			next=sum;//2, 3
		}
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		FibonacciSeries fs = new FibonacciSeries();
		System.out.println("Please Enter the range.");
		int range=input.nextInt();
		fs.GenerateFibonacciSeries(range);
	}

}
