package HackerRank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MakeAnagram {

	
	public static int makeAnagramWithDuplicates(String a, String b) {
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		// creating two hash-maps
		for (int i=0;i<a.length();i++) {
			if (!map1.containsKey(a.charAt(i))) 
				map1.put(a.charAt(i), 1);
			else
				map1.put(a.charAt(i), map1.get(a.charAt(i)) + 1);
        }
		for (int i=0;i<b.length();i++) {
			if (!map2.containsKey(b.charAt(i))) 
				map2.put(b.charAt(i), 1);
			else
				map2.put(b.charAt(i), map2.get(b.charAt(i)) + 1);
        }
		
		return 0;
	}
	
	// Without duplicates
	public static int makeAnagram(String a, String b) {
        Set<Character> set = new HashSet<Character>();
        for (int i=0;i<a.length();i++) {
            set.add(a.charAt(i));
        }
        int unique_count_b = 0, unique_count_a = 0, common_count = 0;
        for (int j=0;j<b.length();j++) {
            if (!set.contains(b.charAt(j))) {
                unique_count_b++;
            }
            else {
                common_count++;
            }
        }
        // now the set contains elements from b which are not in a
        unique_count_a = a.length() - common_count;
        return (unique_count_a + unique_count_b);
    }
	
	public static void main(String[] args) {
		String a = "fcrxzwscanmligyxyvym", b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
		// String a = "tttttttttttttttttttttttttttttttttttttsssssssssssssssss", b = "sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
		int result = MakeAnagram.makeAnagram(a, b);
		System.out.println(result);
	}

}
