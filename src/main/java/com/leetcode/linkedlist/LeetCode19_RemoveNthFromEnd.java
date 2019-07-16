package com.leetcode.linkedlist;

import com.leetcode.model.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 */
public class LeetCode19_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null && n == 1)
            return null;
        ListNode node = head;
        ListNode preNode = null;
        while (node != null) {
            if (n > 0) {
                n--;
            } else if (preNode == null) {
                //链表长度==n
                preNode = head;
            } else {
                //链表长度大于n
                preNode = preNode.next;
            }
            node = node.next;
        }
        if (preNode != null)
            //链表长度大于n
            preNode.next = preNode.next.next;
        else if (n == 0)
            //链表长度==n
            head = head.next;
        return head;
    }
}
