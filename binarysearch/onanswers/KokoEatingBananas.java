package binarysearch.onanswers;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int hoursNeeded = minTimeTakenToEat(piles, mid);

            if (hoursNeeded <= h) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public int minTimeTakenToEat(int[] piles, int k) {
        int totalHours = 0;
        for (int i = 0; i < piles.length; i++) {
            totalHours += Math.ceil((double) piles[i] / (double) k);
        }
        return totalHours;
    }

    public int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            if (max < pile) {
                max = pile;
            }
        }
        return max;
    }
}
