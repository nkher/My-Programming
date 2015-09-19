package SpamFiltering;

public class Node {
	
	int spamCount;
	int hamCount;
	double probability;
	
	public Node(int spamCount, int hamCount) {
		this.spamCount = spamCount;
		this.hamCount = hamCount;
	}
	
	@Override
	public String toString() {
		return String.valueOf(probability);
	}
}
