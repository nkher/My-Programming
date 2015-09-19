package Leetcode.Google;

import java.util.ArrayList;

public class CombinationSumIII {
	
    public static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(result, 1, n, list, k);
        return result;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> result, int start, int sum, ArrayList<Integer> list, int k) {
    	
    	if (sum == 0 && list.size() == k) {
    		ArrayList<Integer> temp = new ArrayList<Integer>();
    		temp.addAll(list);
    		result.add(temp);
    	}
    	
    	for (int i=start; i<=9; i++) {
    		if (sum-i < 0) break; // if sum is exceeded then break
    		if (list.size() > k) break; // if size is more than k then break
    		
    		list.add(i);
    		dfs(result, i+1, sum-i, list, k);
    		list.remove(list.size() - 1); // remove the top and continue
    	}
    }
    
	public static void main(String[] args) {
		
		System.out.println("\nk = 3 and n  = 7 \n\n" + combinationSum3(3, 7).toString());
		
		System.out.println("\nk = 3 and n  = 9 \n\n" + combinationSum3(3, 9).toString());
		
		System.out.println("\nk = 4 and n = 15 \n\n" + combinationSum3(4, 15).toString());
		
		System.out.println("\nk = 6 and n = 25 \n\n" + combinationSum3(6, 25).toString());
	}

}
