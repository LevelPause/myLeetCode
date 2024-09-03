package com.hyperboat.题单.面试经典150题.链表;

/*
 * https://leetcode.cn/problems/add-two-numbers/?envType=study-plan-v2&envId=top-interview-150
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _2两数相加 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode currNode = dummy.next = new ListNode(0);
    while (l1 != null || l2 != null) {
      int curr1 = l1 == null ? 0 : l1.val;
      int curr2 = l2 == null ? 0 : l2.val;
      int sum = curr1 + curr2 + currNode.val;
      int copy = sum;
      int carry = copy / 10;
      currNode.val = sum % 10;
      if (carry > 0 || (l1 != null && l1.next != null) || (l2 != null && l2.next != null)) {
        currNode.next = new ListNode(carry);
      }
      currNode = currNode.next;
      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
    }
    return dummy;
  }
  class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}


