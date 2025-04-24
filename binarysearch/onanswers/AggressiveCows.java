package binarysearch.onanswers;

import java.util.Arrays;


public class AggressiveCows {

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int left = 1;
        int right = getMaxDistance(stalls);
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isCowsAllocation(stalls, mid, k)) {
                result = mid;
                left = mid + 1; // try for a bigger minimum distance
            } else {
                right = mid - 1; // try smaller distance
            }
        }
        return result;
    }
    public static boolean isCowsAllocation(int[] stalls, int distance, int cows) {
        int count = 1; // First cow placed at stalls[0]
        int lastCowStall = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastCowStall >= distance) {
                count++;
                lastCowStall = stalls[i];
            }
            if (count >= cows) {
                return true;
            }
        }
        return false;
    }
    public static int getMaxDistance(int[] stalls) {
        return stalls[stalls.length - 1] - stalls[0];
    }
}

