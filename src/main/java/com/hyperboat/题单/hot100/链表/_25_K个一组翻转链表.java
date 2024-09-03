package com.hyperboat.题单.hot100.链表;

public class _25_K个一组翻转链表 {

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0, head);
    ListNode curr = dummy.next;
    int count = 0;
    while (curr!=null){
      count++;
      curr = curr.next;
      if (count==k){
        ListNode reverse = reverse(curr);
        count=0;
      }
    }
    return dummy.next;
  }

  public ListNode reverse(ListNode node) {
    ListNode pre = null;
    ListNode curr = node;
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
