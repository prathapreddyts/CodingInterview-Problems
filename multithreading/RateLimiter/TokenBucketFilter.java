package multithreading.RateLimiter;

import java.util.HashSet;
import java.util.Set;

class TokenBucketFilter {

    private int MAX_TOKENS; // Maximum capacity of tokens
    private long lastRequestTime = System.currentTimeMillis(); // Last time a token was requested
    private long possibleTokens = 0; // Tokens currently available

    // Constructor to initialize max tokens
    public TokenBucketFilter(int maxTokens) {
        MAX_TOKENS = maxTokens;
    }

    // Method to allow a thread to acquire a token
    public synchronized void getToken() throws InterruptedException
    {

        // Calculate how many tokens could have been added since last request
        possibleTokens += (System.currentTimeMillis() - lastRequestTime) / 1000;

        // Cap the token count to MAX_TOKENS
        if (possibleTokens > MAX_TOKENS) {
            possibleTokens = MAX_TOKENS;
        }

        // If no tokens available, wait for 1 second
        if (possibleTokens == 0) {
            Thread.sleep(1000); // Wait to simulate token refill
        } else {
            possibleTokens--; // Consume one token
        }

        // Update last request timestamp
        lastRequestTime = System.currentTimeMillis();

        System.out.println("Granting " + Thread.currentThread().getName()
                + " token at " + (System.currentTimeMillis() / 1000));
    }

    // Static method to test the TokenBucketFilter with 10 threads
    public static void runTestMaxTokenIs1() throws InterruptedException {
        Set<Thread> allThreads = new HashSet<>();
        final TokenBucketFilter tokenBucketFilter = new TokenBucketFilter(1); // Only 1 token max at a time

        // Create 10 threads using the traditional Runnable approach
        for (int i = 0; i < 10; i++) {
            TokenTask task = new TokenTask(tokenBucketFilter); // Each thread shares the same bucket
            Thread thread = new Thread(task);
            thread.setName("Thread_" + (i + 1));
            allThreads.add(thread);
        }

        // Start all threads
        for (Thread t : allThreads) {
            t.start();
        }

        // Wait for all threads to finish
        for (Thread t : allThreads) {
            t.join();
        }
    }
}

