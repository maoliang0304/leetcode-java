package com.leetcode.linkedlist;

import com.leetcode.model.ListNode;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环
 */
public class LeetCode141_HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            if (slow.next == null) {
                return false;
            }
            slow = slow.next;
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return false;
    }
}
