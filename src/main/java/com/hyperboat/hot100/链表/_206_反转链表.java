package com.hyperboat.hot100.链表;

public class _206_反转链表 {

  public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nxt = curr.next;
      curr.next = pre;
      pre = curr;
      curr = nxt;
    }
    return pre;
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