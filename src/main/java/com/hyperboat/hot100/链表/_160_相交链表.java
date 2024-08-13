package com.hyperboat.hot100.链表;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked
 */
public class _160_相交链表 {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode currA = headA;
    ListNode currB = headB;
    while (currA != null && currB != null) {
      currA = currA.next == null ? headB : currA.next;
      currB = currB.next == null ? headA : currB.next;
      if (currA == currB) {
        return currA;
      }
    }
    return null;
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
