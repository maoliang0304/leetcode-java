package com.leetcode.linkedlist;

import com.leetcode.model.ListNode;

/**
 * 23. 合并K个排序链表
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * https://leetcode-cn.com/problems/merge-k-sorted-lists
 */
public class LeetCode23_MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (ListNode node : lists) {
            result = mergeTwoLists(result, node);
        }
        return result;
    }

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
