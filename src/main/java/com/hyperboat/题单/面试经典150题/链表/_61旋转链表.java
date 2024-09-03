package com.hyperboat.题单.面试经典150题.链表;

/*
 * https://leetcode.cn/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class _61旋转链表 {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    int n = 0;
    ListNode curr = head;
    while (curr != null) {
      n++;
      curr = curr.next;
    }
    int op = k % n;
    if (op == 0) {
      return head;
    }
    ListNode dummy = new ListNode(0, head);
    curr = dummy;
    for (int i = 0; i < n - op; i++) {
      curr = curr.next;
    }
    ListNode nxt = curr.next;
    dummy.next = nxt;
    curr.next = null;
    curr = nxt;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = head;
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