package SpamFiltering;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SpamDetector {
	
	int spamCount = 0;
	int hamCount = 0;
	Map<String, Node> map = new HashMap<String, Node>();
	ArrayList<String> commonWords = new ArrayList<String>();
	BufferedReader br;
	
	
	public void init() throws IOException {
		// Filling the common words map
		fill_list();
		
		// Fill hashmap with spam and ham words
		fill_hashmap_hamwords();
		fill_hashmap_spamwords();
		
		Set<String> keys = map.keySet();
		for (String key : keys) {
			Node node = map.get(key);
			double spamProb = (node.spamCount)/spamCount;
			double hamProb = (node.hamCount)/hamCount;
			double res = spamProb / (spamProb + hamProb);
			node.probability = res;
		}
	}
	
	public void fill_hashmap_hamwords() throws IOException {
		br = new BufferedReader(new FileReader("ham.txt"));
		String line = "";
		
		while ( (line = br.readLine()) != null ) {
			line = line.toLowerCase();
			String words[] = line.split("//s+");
			for (String word : words) {
				if (word.length() > 3 && (!commonWords.contains(word)) ) {
					hamCount++;
					if (map.containsKey(word)) {
						map.get(word).hamCount++;
					} else {
						map.put(word, new Node(0, 1));
					}
				}
			}
		}
		br.close();
	}
	
	public void fill_hashmap_spamwords() throws IOException {
		br = new BufferedReader(new FileReader("spam.txt"));
		String line = "";
		
		while ( (line = br.readLine()) != null ) {
			line = line.toLowerCase();
			String words[] = line.split(" ");
			for (String word : words) {
				if (word.length() > 3 && !commonWords.contains(word)) {
					spamCount++;
					if (map.containsKey(word)) {
						map.get(word).spamCount++;
					} else {
						map.put(word, new Node(1, 0));
					}
				}
			}
		}
	}
	
	
	public void fill_list() throws IOException {
		br = new BufferedReader(new FileReader("common-words.txt"));
		String line = br.readLine();
		
		while (line != null) {
			commonWords.add(line);
			line = br.readLine();
		}	
		br.close();
	}
	
	public void detect(String word) {
		boolean result = false;
		word = word.toLowerCase();
		String wordArr[] = word.split(" ");
		TreeMap<Double, List<Double>> interestMap = new TreeMap<Double, List<Double>>();
		for (String x : wordArr) {
			if (x.length() > 3 && !commonWords.contains(x)) {
				double i = 0.5;
				double p = 0.5;
				if (map.containsKey(x)) {
					p = map.get(x).probability;
				}
				i = Math.abs(i - p);
				if (!interestMap.containsKey(i)) {
					List<Double> values = new ArrayList<Double>();
					values.add(p);
					interestMap.put(i, values);
				} else {
					interestMap.get(i).add(p);
				}
			}
		}
		
		ArrayList<Double> probabilities = new ArrayList<Double>();
		int count = 0;
		Set<Double> set = interestMap.keySet();
		for (Double d : set) {
			List<Double> list = interestMap.get(d);
			for (Double x : list) {
				count++;
				probabilities.add(x);
				if (count == 15) break;
			}
			if (count == 15) break;
		}
		
		double res = 1;
		double numerator = 1;
		double denominator = 1;
		for (Double d : probabilities) {
			numerator *= d;
			denominator *= d;
		}
		res = numerator / (double) (numerator + denominator);
		if (res >= 0.9) result = true;
		
		if (result) System.out.println(word  + " is a spam.");
		
		else System.out.println(word + " is not a spam. ");
	}
	
	public void moveToSpam() {
		
	}
	
	public static void main(String args[]) throws IOException  {
		SpamDetector spamDetector = new SpamDetector();
		spamDetector.init();
		
		spamDetector.detect("Quick and easy jobsite");
		spamDetector.detect("Will there be a Production Release tomorrow");
	}
	
}

