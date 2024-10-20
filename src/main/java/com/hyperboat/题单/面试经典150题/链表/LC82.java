package com.hyperboat.题单.面试经典150题.链表;

/*
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/?envType=study-plan-v2&envId=top-interview-150
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LC82 {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(-101, head);
    ListNode curr = dummy;
    while (curr.next != null && curr.next.next != null) {
      int val = curr.next.val;
      if (curr.next.next.val == val) {
        while (curr.next != null && curr.next.val == val) {
          curr.next = curr.next.next;
        }
      } else {
        curr = curr.next;
      }
    }
    return dummy.next;
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