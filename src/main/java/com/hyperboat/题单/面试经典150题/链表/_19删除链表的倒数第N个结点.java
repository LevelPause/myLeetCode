package com.hyperboat.题单.面试经典150题.链表;

/*
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _19删除链表的倒数第N个结点 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    return doublePoint(head, n);
  }

  /*
   * 算出 链表长度length, 然后走length步删除第n个节点
   * */
  public ListNode count(ListNode head, int n) {
    // 节点个数
    int length = 0;
    ListNode dummy = new ListNode(0, head);
    ListNode curr = dummy.next;
    while (curr != null) {
      length++;
      curr = curr.next;
    }
    curr = dummy;
    while (length - n > 0) {
      curr = curr.next;
      length--;
    }
    if (curr.next != null) {
      curr.next = curr.next.next;
    } else {
      curr.next = null;
    }
    return dummy.next;

  }

  /*
   * 双指针， r先走n步, 然后l和r一起走, 当r走到头的时候, l就处在倒数第n-1个节点, 由此删除倒数第n个节点即可
   * */
  public ListNode doublePoint(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode r = dummy;
    while (n-- > 0) {
      r = r.next;
    }
    ListNode l = dummy;
    while (r.next != null) {
      r = r.next;
      l = l.next;
    }
    l.next = l.next.next;
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
