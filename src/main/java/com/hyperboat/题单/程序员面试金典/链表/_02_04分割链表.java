package com.hyperboat.题单.程序员面试金典.链表;

/*
 * https://leetcode.cn/problems/partition-list-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * */
class _02_04分割链表 {

  public ListNode partition(ListNode head, int x) {
    ListNode lDummy = new ListNode(-1);
    ListNode sDummy = new ListNode(-1);
    ListNode l = lDummy;
    ListNode s = sDummy;
    while (head != null) {
      if (head.val < x) {
        s.next = head;
        s = s.next;
      } else {
        l.next = head;
        l = l.next;
      }
      head = head.next;
    }
    l.next = null;
    s.next = lDummy.next;
    return sDummy.next;
  }

  public void swap(ListNode preL, ListNode l, ListNode preR, ListNode r) {
    ListNode t = l.next;
    l.next = r.next;
    r.next = t;
    preL.next = r;
    preR.next = l;
  }

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
