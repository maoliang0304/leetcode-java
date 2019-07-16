package com.leetcode.linkedlist;

import com.leetcode.model.ListNode;
import org.junit.Test;

/**
 * 2. 两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers
 */
public class LeetCode02_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l3 = new ListNode(0);
        ListNode cur = l3;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0)
            cur.next = new ListNode(carry);
        return l3.next;
    }

    @Test
    public void test() {

        ListNode l1 = ListNode.build(342);
        ListNode l2 = ListNode.build(465);

        ListNode l3 = addTwoNumbers(l1, l2);

        int num = 0;
        int multiple = 1;
        while (l3 != null) {
            int val = l3.val;
            num = num + val % 10 * multiple;
            multiple = multiple * 10;
            l3 = l3.next;
        }

        assert num == 807;
    }
}
