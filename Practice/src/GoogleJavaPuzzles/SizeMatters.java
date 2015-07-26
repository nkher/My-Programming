package GoogleJavaPuzzles;

import java.util.AbstractMap;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SizeMatters {
	
	private enum Sex{MALE, FEMALE}
	
	private static int size(Map<Sex, Sex> map){
		map.put(Sex.MALE, Sex.FEMALE);
		map.put(Sex.FEMALE, Sex.MALE);
		map.put(Sex.MALE, Sex.MALE);
		map.put(Sex.FEMALE, Sex.FEMALE);
		
		Set<Map.Entry<Sex, Sex>> set = new HashSet<Map.Entry<Sex, Sex>>();
		//Create an empty has set and iterate over all the entries
		for(Map.Entry<Sex, Sex> e : map.entrySet())
			set.add(new AbstractMap.SimpleImmutableEntry<Sex, Sex>(e));
		
		return set.size();
	}
	
	public static void main(String[] args) {
		
		System.out.println(size(new HashMap<Sex, Sex>()) + " "); //It should print 2
		System.out.println(size(new EnumMap<Sex, Sex>(Sex.class)) + " "); //It should print 2
		
		//Answer is that it prints 2,1 over 2,2
		//This is because the EnumMaps entrySet Iterator repeatedly returns the same same Entry :( !!
		//Inside an Enum Map we have an array of values	

	}

}
