package com.hyperboat.hot100.链表;

/*
 * https://leetcode.cn/problems/add-two-numbers/?envType=study-plan-v2&envId=top-100-liked
 * */
public class _2_两数相加 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (l1 != null || l2 != null) {
      if (l1 != null) {
        carry += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        carry += l2.val;
        l2 = l2.next;
      }
      curr.next = new ListNode(carry % 10);
      curr = curr.next;
      carry /= 10;
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
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
