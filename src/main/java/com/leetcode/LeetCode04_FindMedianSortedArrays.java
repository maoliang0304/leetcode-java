package com.leetcode;

import org.junit.Test;

/**
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class LeetCode04_FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        //是否偶数
        boolean isEvenNumber = length % 2 == 0;
        //中位下表
        int medianSubScript = length / 2 + 1;
        //两个指针
        int subScript1 = 0;
        int subScript2 = 0;

        int[] num3 = new int[medianSubScript];
        for (int i = 0; i < medianSubScript; i++) {
            if (subScript1 == nums1.length) {
                num3[i] = nums2[subScript2++];
            } else if (subScript2 == nums2.length) {
                num3[i] = nums1[subScript1++];
            } else if (nums1[subScript1] < nums2[subScript2]) {
                num3[i] = nums1[subScript1++];
            } else {
                num3[i] = nums2[subScript2++];
            }
        }

        if (isEvenNumber) {
            return (num3[medianSubScript - 2] + num3[medianSubScript - 1]) / 2.0;
        } else {
            return num3[medianSubScript - 1] / 1.0;
        }
    }

    @Test
    public void test1() {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double result = new LeetCode04_FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2);
        assert result == 2.0;
    }

    @Test
    public void test2() {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double result = new LeetCode04_FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2);
        assert result == 2.5;
    }
}
