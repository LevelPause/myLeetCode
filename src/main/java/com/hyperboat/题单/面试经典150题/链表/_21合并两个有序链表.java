package com.hyperboat.题单.面试经典150题.链表;

/*
 * https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-interview-150
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class _21合并两个有序链表 {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    return yuandi(list1, list2);
  }

  /*
   * 在原来的链表上拼接，不再新生成一条链表
   * */
  public ListNode yuandi(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode();
    ListNode curr = dummy;
    while (list1 != null && list2 != null) {
      if (list1.val > list2.val) {
        curr.next = list2;
        list2 = list2.next;
      } else {
        curr.next = list1;
        list1 = list1.next;
      }
      curr = curr.next;
    }

    if (list1 != null) {
      curr.next = list1;
    }
    if (list2 != null) {
      curr.next = list2;
    }
    return dummy.next;
  }

  /*
   * 新生成一条链表
   * */
  public ListNode newNode(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode();
    ListNode curr = dummy;
    while (list1 != null && list2 != null) {
      if (list1.val > list2.val) {
        curr = curr.next = new ListNode(list2.val);
        list2 = list2.next;
      } else {
        curr = curr.next = new ListNode(list1.val);
        list1 = list1.next;
      }
    }
    while (list1 != null) {
      curr = curr.next = new ListNode(list1.val);
      list1 = list1.next;
    }
    while (list2 != null) {
      curr = curr.next = new ListNode(list2.val);
      list2 = list2.next;
    }
    return dummy.next;
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
