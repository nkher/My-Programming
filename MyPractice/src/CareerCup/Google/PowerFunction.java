package CareerCup.Google;

public class PowerFunction {
	
	// Time comp = O(n)
	public static int power(int num, int p) {
		if (p == 0) return 1;
		
		if ( (p&1) == 0 ) {
			return power(num, p/2) * power(num, p/2);
		}
		else {
			return (num * power(num, p/2) * power(num, p/2));
		}
	}
	
	// Time - O(logN), here we first calculate the temp value by calling the power function recursively only once
	// then we do the same calculation as above
	public static int powerEff(int num, int p) {
		int temp;
		if (p == 0) return 1;
		
		temp = power(num, p/2);
		if ( (p&1) == 0 ) {
			return temp * temp;
		}
		else {
			return num * temp * temp;
		}
	}
	
	// Time com = O(logN)
	public static double powerWithFloatAndNegative(double x, double y) {
		double temp;
		if(y==0.0)
			return 1.0;
		
		temp = powerWithFloatAndNegative(x, y/2);
	
		if( y%2 == 0.0 )
			return (double)temp*temp;
		else{
			if (y > 0.0)
				return (double)x*temp*temp;
			else 
				return (double)(temp*temp)/x;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(power(8, 3));
		
		System.out.println(powerEff(8, 3));
		
		System.out.println(powerWithFloatAndNegative(4.00, 2.00));
	}
}
