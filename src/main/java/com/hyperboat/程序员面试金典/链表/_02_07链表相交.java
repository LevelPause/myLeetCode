package com.hyperboat.程序员面试金典.链表;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class _02_07链表相交 {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode currA = headA;
    ListNode currB = headB;
    while (currA != currB) {
      currA = currA != null ? currA.next : headB;
      currB = currB != null ? currB.next : headA;
    }
    return currA;
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
