package com.hyperboat.hot100.链表;

/*
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-100-liked
 * */
public class _19_删除链表的倒数第N个结点 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode fast = dummy;
    ListNode slow = dummy;
    while (n-- > 0) {
      fast = fast.next;
    }
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
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
