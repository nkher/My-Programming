package TopCoder;

public class AB {
	
    public String createString(int N, int K) {
        
        int len = N, pairs = K;
        if (len == 0) return "";
        
        // Second condition
        StringBuffer sb =  new StringBuffer();
        if (pairs == 0 &&  len > 0) {
            int mid = len/2;
            while (len > mid) {
                sb.append("B");
                len--;
            }
            while (len > 0) {
                sb.append("A");
                len--;
            }
            return new String(sb);
        }
        
        // second condition
        if (pairs > len) {
            boolean canMake = false;
            int noB = len-1;
            while (noB > len/2) {
                int noA = len - noB; // 1
                if ( (noA * noB) >= pairs ) { // we can make that much of len hence break
                    canMake = true;
                    break;
                }
                noB--;
            }
            if (!canMake) return "";
        }
        
        // Handling the last condition
        char[] str = new char[len];
     	int noB = pairs/2, i = len-1, noA = 2;
		while (noB > 0) { 
            str[i--] = 'B'; 
            noB--; 
        }
		while (noA > 0) { 
            str[i--] = 'A'; 
            noA--; 
        }
		while (i >= 0) str[i--] = 'B';
        
        return new String(str);
    }
    
    public static void main(String args[]) {
    	AB obj = new AB();
    	
    	System.out.println(obj.createString(3, 2));
    	System.out.println(obj.createString(2, 0));
    	System.out.println(obj.createString(5, 8));
    	System.out.println(obj.createString(10, 12));
    }
}