package com.hyperboat.题单.hot100.链表;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-100-liked
 */
public class _21_合并两个有序链表 {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        curr.next = list1;
        list1 = list2.next;
      } else {
        curr.next = list2;
        list2 = list2.next;
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
