package com.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * https://leetcode-cn.com/problems/two-sum
 */
public class LeetCode01_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (map.containsKey(target - a)) {
                temp[0] = map.get(target - a);
                temp[1] = i;
                return temp;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = new LeetCode01_TwoSum().twoSum(nums, target);

        assert result.length == 2;
        assert result[0] == 0;
        assert result[1] == 1;
    }
}
