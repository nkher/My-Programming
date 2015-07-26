
public class EggDrop {
	
	public static int getMax(int a, int b) {
		return (a > b) ? a:b;
	}
	
	/* Function to get minimum number of trails needed in worst
	  case with noOfeggs and floors */
	public static int eggDrop(int noOfEggs, int floors) {
		// If there are no floors, then no trials needed. OR if there is
	    // one floor, one trial needed.
		if (floors == 0 || floors ==1)
			return floors;
		
		// We need all trials for one egg and k floors
		if(noOfEggs == 1) 
			return floors;
		
		int min = Integer.MAX_VALUE, res, x;
		// Consider all droppings from 1st floor to last floor and
	    // return the minimum of these values plus 1.
		for (x=1;x<=floors;x++) {
			res = getMax(eggDrop(noOfEggs-1, x-1), eggDrop(noOfEggs, floors-x));
			if (res < min)
				min = res;
		}
		return min+1;
	}
	
	public static void main(String[] args) {
		int noOfEggs = 2;
		int floors = 100;
		int minDrops = EggDrop.eggDrop(noOfEggs, floors);
		System.out.println(minDrops);
	}

}
