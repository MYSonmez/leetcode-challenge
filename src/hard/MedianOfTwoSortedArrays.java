package hard;

import java.util.ArrayList;

/**
 * QUESTION: Given two sorted arrays 'nums1' and 'nums2' of size m and n
 * respectively, return the median of the two sorted arrays.
 *
 * @author m.yusufsonmez03@gmail.com
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int size = len1 + len2;

        if (len1 == 0) {
            if (len2 % 2 == 0) {
                return ((double) nums2[(len2 / 2) - 1] + nums2[(len2 / 2)]) / 2;
            }
            return nums2[((len2 - 1) / 2)];
        } else if (len2 == 0) {
            if (len1 % 2 == 0) {
                return ((double) nums1[(len1 / 2) - 1] + nums1[(len1 / 2)]) / 2;
            }
            return nums1[((len1 - 1) / 2)];
        }

        ArrayList<Integer> arrayList3 = new ArrayList<>(size);
        int j = 0, i = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) {
                arrayList3.add(nums1[i]);
                i++;
            } else if (nums1[i] > nums2[j]) {
                arrayList3.add(nums2[j]);
                j++;
            }
        }
        if (i < len1) {
            for (k = i; k < len1; k++) {
                arrayList3.add(nums1[k]);
            }
        } else if (j < len2) {
            for (k = j; k < len2; k++) {
                arrayList3.add(nums2[k]);
            }
        }
        if (size % 2 == 0) {
            return ((double) arrayList3.get((size / 2) - 1) + arrayList3.get((size / 2))) / 2;
        }
        return arrayList3.get(((size - 1) / 2));
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 2, 2, 2, 4}, new int[]{1, 2, 2, 2, 2, 2});
    }
}
