package com.leetcode.linkedlist;

import com.leetcode.model.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 */
public class LeetCode83_DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = pre.next;
        }
        return head;
    }
}
