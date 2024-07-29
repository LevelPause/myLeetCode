package com.hyperboat.面试经典150题.链表;

/*
 * https://leetcode.cn/problems/reverse-linked-list-ii/?envType=study-plan-v2&envId=top-interview-150
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class _92反转链表II {

  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(-1, head);
    ListNode p0 = dummy;
    int index = 1;
    while (index < left) {
      p0 = p0.next;
      index++;
    }
    ListNode pre = null;
    ListNode curr = p0.next;
    while (index++ < right) {
      ListNode nxt = curr.next;
      curr.next = pre;
      pre = curr;
      curr = nxt;
    }
    p0.next.next = curr;
    p0.next = pre;
    return dummy.next;
  }

  public class ListNode {

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
