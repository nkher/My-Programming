package Google;

public class DateRangeOverLap {
	
	public static boolean dateoverlap(DateRange d1, DateRange d2) {
		
		if (d2.start > d1.end || d1.start > d2.end) {
			return false;
		}
		else if ( ( (d2.start > d1.start && d2.start < d1.end) && (d2.end > d1.start && d2.end < d1.end) )
				  || ( (d1.start > d2.start && d1.start < d2.end) && (d1.end > d2.start && d1.end < d2.end) ) ) { // one date is within the other
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		
		DateRange d1 = new DateRange(0, 5);
		DateRange d2 = new DateRange(4, 9);
		
		System.out.println(dateoverlap(d1, d2));
		
		DateRange d3 = new DateRange(0, 5);
		DateRange d4 = new DateRange(4, 4);
		
		System.out.println(dateoverlap(d3, d4));
		
		DateRange d5 = new DateRange(10, 20);
		DateRange d6 = new DateRange(5, 25);
		
		System.out.println(dateoverlap(d3, d4));
	}
}

class DateRange {
	public int start, end;
	
	public DateRange() {}
	
	public DateRange(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
}
