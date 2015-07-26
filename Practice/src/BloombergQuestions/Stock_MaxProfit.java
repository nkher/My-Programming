package BloombergQuestions;

import java.util.Random;

// Program to get the maximum profit from an array of stock values
public class Stock_MaxProfit {
	
	// Function that returns maximum profit in time complexity O(N) 
	public static int getMaxProfit(Stock stock[]){
		// variable to store the Maximum Profit, minimum 
		// value in array and current profit at each iteration
		int maxProfit = Integer.MIN_VALUE; 
		int minAsOfNow = stock[0].price; 
		int currentProfit = 0;
		for (Stock s : stock) {
			currentProfit = s.price - minAsOfNow;
			maxProfit = Math.max(maxProfit, currentProfit);
			minAsOfNow = Math.min(s.price, minAsOfNow);
		}
		return maxProfit;
	}
	
	public static void printDayWisePrices(Stock[] stock) {
		for (Stock s : stock) {
			System.out.println(s.day + "  --> " + s.price);
		}
	}
	
	public static void main(String[] args) {
		
		Stock stock[] =  new Stock[7];
		Random random =  new Random();
		// Creating an array of type Stocks to store the prices and days
		for (int i=0;i<stock.length; i++) {
			stock[i] = new Stock("Day "+i, random.nextInt(100));
		}
		printDayWisePrices(stock);
		System.out.println("\nMax Profit is form the given array is : " + getMaxProfit(stock));
	}

}

// Data Structure to hold the day and its prices
class Stock {
	String day;
	int price;
	
	public Stock(String day, int price) {
		this.day = day;
		this.price = price;
	}
}
