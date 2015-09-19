package TopCoder;

// 216.38 / 250 points
public class AccessLevel {
	
	public static String canAccess(int[] rights, int minPermission) {
		StringBuilder sb = new StringBuilder();
		
		if (rights.length == 0) {
			return sb.append("\"\"").toString();
		}
		
		for (int i=0;i<rights.length;i++) {
			if (rights[i] < minPermission) {
				sb.append("D");
			}
			else {
				sb.append("A");
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		int r1[] = {0,1,2,3,4,5};
		int mP1 = 2;
		System.out.println(canAccess(r1, mP1));
		
		int r2[] = {5,3,2,10,0};
		int mP2 = 20;
		System.out.println(canAccess(r2, mP2));
		
		int r3[] = {};
		int mP3 = 20;
		System.out.println(canAccess(r3, mP3));
		
		int r4[] = {34,78,9,52,11,1};
		int mp4 = 49;
		System.out.println(canAccess(r4, mp4));
	}

}
