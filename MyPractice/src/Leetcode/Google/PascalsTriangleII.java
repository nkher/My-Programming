package Leetcode.Google;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	
	public static List<Integer> getRow(int rowIndex) {
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
     
        if (rowIndex == 0) return list;
        
        List<Integer> prev;
        
        for (int i=2; i<=rowIndex+1; i++) {
            prev = list;
            list = new ArrayList<Integer>(i);
                        
            list.add(0, prev.get(0)); // first value
            // filling middle values
            for (int j=1; j<i-1; j++) {
                list.add(j, (prev.get(j) + prev.get(j-1)));
            }
            list.add(i-1, 1); // last value            
        }
        return list;
    }
	
	public static void main(String[] args) {

		System.out.println(getRow(1).toString());
	}

}
