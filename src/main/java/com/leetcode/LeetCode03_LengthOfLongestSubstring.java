package com.leetcode;

import org.junit.Test;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class LeetCode03_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int end = 0, start = 0;
        java.util.Set<Character> set = new java.util.HashSet<>();
        while (start < n && end < n) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                res = Math.max(res, end - start);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int result = new LeetCode03_LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb");
        assert result == 3;
    }
}
