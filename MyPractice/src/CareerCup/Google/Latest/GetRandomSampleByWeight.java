package CareerCup.Google.Latest;

public class GetRandomSampleByWeight {

	public static int randomSampleByWeight(Pair[] pairs) {
		
		int sum = 0, sample = Integer.MIN_VALUE;
		
		for (int i=0; i<pairs.length; i++) {
			int id = pairs[i].x;
			int weight = pairs[i].y;
			
			if (id == 0 && weight == 0) break;
			sum += weight;
			int p = (int) (Math.random()*(double) sum);
			if (p <= weight) {
				sample = id;
			}
		}
		
		return sample;
	}
	
	public static void main(String[] args) {
		
		Pair[] pairs = {new Pair(1, 2), new Pair(2, 2), new Pair(3, 4), new Pair(4, 10)};
		
		System.out.println(randomSampleByWeight(pairs));
	}

}
