package com.hyperboat.题单.hot100.链表;

/**
 * 234. 回文链表
 * <p>
 * https://leetcode.cn/problems/palindrome-linked-list/?envType=study-plan-v2&envId=top-100-liked
 */
class LC234 {

  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode reverse = reverse(slow.next);
    ListNode l = head;
    ListNode r = reverse;
    boolean res = true;
    while (res && l != null && r != null) {
      if (l.val != r.val) {
        res = false;
      }
      l = l.next;
      r = r.next;
    }
    slow.next = reverse(reverse);
    return res;
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
