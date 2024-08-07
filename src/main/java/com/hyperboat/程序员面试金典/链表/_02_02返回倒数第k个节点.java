package com.hyperboat.程序员面试金典.链表;

/*
 * https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * */
public class _02_02返回倒数第k个节点 {

  public int kthToLast(ListNode head, int k) {
    ListNode curr = head;
    ListNode kthNode = head;
    while (curr.next != null) {
      if (k != 0) {
        k--;
      } else {
        kthNode = kthNode.next;
      }
      curr = curr.next;
    }
    return kthNode.val;
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
