package com.leetcode.model;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }


    public static ListNode build(int num) {
        int dividend = 10;
        ListNode node = new ListNode(num % dividend);
        ListNode currentNode = node;
        num = num / 10;
        while (num > 0) {
            int val = num % dividend;
            num = num / 10;
            ListNode nextNode = new ListNode(val);
            currentNode.next = nextNode;
            currentNode = nextNode;
        }
        return node;
    }

    public static ListNode build(int[] nums) {
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = cur.next;
        }
        return listNode.next;
    }
}
