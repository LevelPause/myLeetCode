package com.hyperboat.题单.程序员面试金典.链表;

/**
 * 面试题 02.05. 链表求和
 * <p>
 * https://leetcode.cn/problems/sum-lists-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
class LCI0205 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode dummy = new ListNode(-1);
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
      ListNode sum = new ListNode(carry % 10);
      carry /= 10;
      curr.next = sum;
      curr = curr.next;
    }
    if (carry > 0) {
      curr.next = new ListNode(carry);
    }
    return dummy.next;
  }

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
