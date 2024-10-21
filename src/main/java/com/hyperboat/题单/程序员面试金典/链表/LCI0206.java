package com.hyperboat.题单.程序员面试金典.链表;

/**
 * 面试题 02.06. 回文链表
 * <p>
 * https://leetcode.cn/problems/palindrome-linked-list-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
class LCI0206 {

  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    ListNode halfNode = getHalfNode(head);
    ListNode tailNode = reverseNode(halfNode.next);
    while (tailNode != null) {
      if (tailNode.val != head.val) {
        return false;
      } else {
        tailNode = tailNode.next;
        head = head.next;
      }
    }
    return true;
  }

  public ListNode reverseNode(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nxt = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nxt;
    }
    return prev;
  }

  public ListNode getHalfNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

}
