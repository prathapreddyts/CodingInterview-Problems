package binarysearch.onanswers;

public class CapacityToShipPackages {
    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights); // Minimum capacity must be at least the max weight
        int right = getSum(weights); // Maximum capacity is sum of all weights

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (shipCapacity(weights, mid) <= D) {
                right = mid; // Try a smaller capacity
            } else {
                left = mid + 1; // Need more capacity
            }
        }
        return left; // or right, since left == right here
    }

    private int shipCapacity(int[] weights, int capacity) {
        int days = 1;
        int total = 0;
        for (int weight : weights) {
            total += weight;
            if (total > capacity) {
                days++;
                total = weight;
            }
        }
        return days;
    }

    private int getMax(int[] weights) {
        int max = weights[0];
        for (int weight : weights) {
            max = Math.max(max, weight);
        }
        return max;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }

}
