package GoogleJavaPuzzles;

import java.math.BigDecimal;

public class Change {

	public static void main(String[] args) {
		
		//Lesson1 -- Avoif float and double where exact answers are required
		System.out.println(2.0-1.10); //Does not give exact 0.90
		
		BigDecimal payment = new BigDecimal(2.0);
		BigDecimal cost = new BigDecimal(1.10);
		System.out.println(payment.subtract(cost)); //Does not give exact 0.90
		//This is because we are using the wrong big decimal constructor
		
		//Using string cons
		BigDecimal pBigDecimal = new BigDecimal("2.0");
		BigDecimal cBigDecimal = new BigDecimal("1.10");
		System.out.println(pBigDecimal.subtract(cBigDecimal)); //Gives exact 0.90
		
	}

}
