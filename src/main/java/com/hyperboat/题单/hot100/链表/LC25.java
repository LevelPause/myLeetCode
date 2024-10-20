package com.hyperboat.题单.hot100.链表;

/**
 * 25. K个一组翻转链表
 * <p>
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 */
class LC25 {

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0, head);
    ListNode curr = dummy.next;
    int count = 0;
    while (curr != null) {
      count++;
      curr = curr.next;
      if (count == k) {
        ListNode reverse = reverse(curr);
        count = 0;
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
