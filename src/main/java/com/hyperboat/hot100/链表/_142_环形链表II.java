package com.hyperboat.hot100.链表;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/?envType=study-plan-v2&envId=top-100-liked
 */
public class _142_环形链表II {

  public ListNode detectCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        break;
      }
    }
    if (fast == null) {
      return null;
    }
    fast = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
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
