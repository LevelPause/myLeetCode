package com.hyperboat.hot100.链表;

/**
 * https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-100-liked
 */
public class _141_环形链表 {

  public boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
