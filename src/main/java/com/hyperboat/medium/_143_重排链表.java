package com.hyperboat.medium;

public class _143_重排链表 {

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

  class Solution {

    public void reorderList(ListNode head) {
      ListNode dummy = new ListNode(0, head);
      ListNode slow = dummy;
      ListNode fast = dummy;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      ListNode reverse = reverse(slow.next);
      ListNode curr = dummy.next;
      while (reverse!=null){
        ListNode nxt = curr.next;
        curr.next = reverse;
        ListNode reNext = reverse.next;
        reverse.next = nxt;
        curr = nxt;
        reverse = reNext;
      }
    }

    public ListNode reverse(ListNode node) {
      ListNode pre = null;
      while (node != null) {
        ListNode nxt = node.next;
        node.next = pre;
        pre = node;
        node = nxt;
      }
      return pre;
    }
  }
}
