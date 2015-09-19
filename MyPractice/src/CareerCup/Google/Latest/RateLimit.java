package CareerCup.Google.Latest;

public interface RateLimit {
	
	/* set rate between one and 100000 */
	void setQPS(int qps);
	boolean allowThisRequest();
}
