package com.hyperboat.题单.程序员面试金典.链表;

/**
 * /** 面试题 02.02. 返回倒数第 k 个节点
 * <p>
 * https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
class LCI0202 {

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

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
