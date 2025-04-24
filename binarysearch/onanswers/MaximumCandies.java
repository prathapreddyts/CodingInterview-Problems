package binarysearch.onanswers;

public class MaximumCandies {
    public int maximumCandies(int[] candies, long k) {
        if (sum(candies) < k) {
            return 0;
        }

        int left = 1, right = getMax(candies);
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(candies, k, mid)) {
                result = mid;     // this mid is valid
                left = mid + 1;   // try for more
            } else {
                right = mid - 1;
            }
        }
        return result;

    }

    private boolean canDistribute(int[] candies, long k, int pileSize) {
        if (pileSize == 0) return true;
        long totalPiles = 0;
        for (int candy : candies) {
            totalPiles += candy / pileSize;
            if (totalPiles >= k) {
                return true;
            }
        }
        return false;
    }

    private long sum(int[] candies) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }

    private int getMax(int[] candies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        return max;
    }
}
