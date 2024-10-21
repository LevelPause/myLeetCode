package com.hyperboat.题单.面试经典150题.链表;

/*
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LC25 {

  public ListNode reverseKGroup(ListNode head, int k) {
    int n = 0;
    ListNode curr = head;
    while (curr != null) {
      n++;
      curr = curr.next;
    }
    ListNode dummy = new ListNode(0, head);
    ListNode p0 = dummy;
    ListNode pre = null;
    curr = p0.next;
    while (n >= k) {
      for (int i = 0; i < k; i++) {
        ListNode nxt = curr.next;
        curr.next = pre;
        pre = curr;
        curr = nxt;
      }
      ListNode nxt = p0.next;
      p0.next.next = curr;
      p0.next = pre;
      p0 = nxt;
      n -= k;
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
