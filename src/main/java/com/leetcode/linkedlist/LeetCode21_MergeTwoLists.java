package com.leetcode.linkedlist;

import com.leetcode.model.ListNode;

/**
 * 21. 合并两个有序链表
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
public class LeetCode21_MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode node = l3;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            if (val1 < val2) {
                l1 = l1.next;
                ListNode l = new ListNode(val1);
                node.next = l;
                node = node.next;
            } else {
                l2 = l2.next;
                ListNode l = new ListNode(val2);
                node.next = l;
                node = node.next;
            }
        }
        if (l1 != null) {
            node.next = l1;
        } else {
            node.next = l2;
        }
        return l3.next;
    }
}
