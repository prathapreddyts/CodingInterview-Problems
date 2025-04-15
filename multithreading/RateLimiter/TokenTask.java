package multithreading.RateLimiter;

public class TokenTask implements Runnable {
    private TokenBucketFilter tokenBucketFilter;

    public TokenTask(TokenBucketFilter tokenBucketFilter) {
        this.tokenBucketFilter = tokenBucketFilter;
    }

    @Override
    public void run() {
        try {
            tokenBucketFilter.getToken();
        } catch (InterruptedException ie) {
            System.out.println("We have a problem in " + Thread.currentThread().getName());
        }
    }
}
