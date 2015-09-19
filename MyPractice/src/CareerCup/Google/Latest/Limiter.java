package CareerCup.Google.Latest;

public class Limiter implements RateLimit {

	long time = -1;
	int qps;
	long qpsMillis;
	
	public Limiter(int qps) {
		setQPS(qps);
	}
	
	public void setQPS(int qps) {
		if (qps < 1 || qps > 100000) {
			throw new RuntimeException("Your passed qps is out of expected range.");
		}
		this.qps = qps;
		qpsMillis = qps * 1000;
	}

	public boolean allowThisRequest() {
		long currentTime = System.currentTimeMillis();
		if (time == -1) {
			time = currentTime;
			return true;
		}
		else {
			long result = currentTime - time;
			if (result < qpsMillis) {
				return false;
			}
			else {
				time = currentTime;
				return true;
			}
		}
	}
	
	
	public static void main(String args[]) throws InterruptedException {
		
		int t = 1;
		Limiter req1 = new Limiter(t);
		System.out.println(req1.allowThisRequest());
		System.out.println(req1.allowThisRequest());
		System.out.println(req1.allowThisRequest());
		Thread.sleep(5);
		System.out.println(req1.allowThisRequest());


	}
}
