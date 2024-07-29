package com.hyperboat.面试经典150题.链表;

/*
 * https://leetcode.cn/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class _86分隔链表 {

  // 分割成一大一小两个链表， 最后再拼接起来
  public ListNode partition(ListNode head, int x) {
    ListNode smallDummy = new ListNode(0);
    ListNode bigDummy = new ListNode(0);
    ListNode small = smallDummy, big = bigDummy;
    while (head != null) {
      if (head.val < x) {
        small.next = head;
        small = small.next;
      } else {
        big.next = head;
        big = big.next;
      }
      head = head.next;
    }
    small.next = bigDummy.next;
    big.next = null;
    return smallDummy.next;
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