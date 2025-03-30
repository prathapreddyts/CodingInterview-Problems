package twopointers;

import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        int[] merged = new int[m + n];
        int nstart = 0;
        int mstart = 0;
        while (nstart < m && mstart < n) {
            if (nums1[nstart] < nums2[mstart]) {
                merged[index++] = nums1[nstart++];
            } else {
                merged[index++] = nums2[mstart++];
            }
        }
        while (nstart < m) {
            merged[index++] = nums1[nstart++];
        }
        while (mstart < n) {
            merged[index++] = nums2[mstart++];
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = merged[i];
        }
    }
    
}
