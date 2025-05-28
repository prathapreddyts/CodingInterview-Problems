package hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxAndMinFeqSum {
    public int sumHighestAndLowestFrequency(int[] nums) {
        int n = nums.length;
        int maxFreq = 0, minFreq = n;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }
        for (int freq : mpp.values()) {
            maxFreq = Math.max(maxFreq, freq);
            minFreq = Math.min(minFreq, freq);
        }
        return maxFreq + minFreq;
    }

    public int secondMostFrequentElement(int[] nums) {

        int n = nums.length;
        int maxFreq = 0, secMaxFreq = 0;
        int maxEle = -1, secEle = -1;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            int ele = it.getKey(); // Key
            int freq = it.getValue(); // Value
            if (freq > maxFreq) {
                secMaxFreq = maxFreq;
                maxFreq = freq;
                secEle = maxEle;
                maxEle = ele;
            } else if (freq == maxFreq) {
                maxEle = Math.min(maxEle, ele);
            } else if (freq > secMaxFreq) {
                secMaxFreq = freq;
                secEle = ele;
            } else if (freq == secMaxFreq) {
                secEle = Math.min(secEle, ele);
            }
        }
        return secEle;
    }

    public int mostFrequentElement(int[] nums) {

        int n = nums.length;
        int maxFreq = 0;
        int maxEle = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            int ele = it.getKey(); // Key
            int freq = it.getValue(); // Value
            if (freq > maxFreq) {
                maxFreq = freq;
                maxEle = ele;
            } else if (freq == maxFreq) {
                maxEle = Math.min(maxEle, ele);
            }
        }
        return maxEle;
    }
}
