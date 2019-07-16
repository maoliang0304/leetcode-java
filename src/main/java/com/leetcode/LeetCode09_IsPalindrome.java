package com.leetcode;

import org.junit.Test;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数
 * <p>
 * https://leetcode-cn.com/problems/palindrome-number
 */
public class LeetCode09_IsPalindrome {

    public boolean isPalindrome(int x) {
        //负数、末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        //通过取整和取余操作获取整数中对应的数字进行比较
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    @Test
    public void test() {
        boolean result = new LeetCode09_IsPalindrome().isPalindrome(121);
        assert result;
    }

    @Test
    public void test2() {
        boolean result = new LeetCode09_IsPalindrome().isPalindrome(-121);
        assert !result;
    }

    @Test
    public void test3() {
        boolean result = new LeetCode09_IsPalindrome().isPalindrome(10);
        assert !result;
    }
}
