package com.hyperboat.题单.程序员面试金典.链表;

/*
 * https://leetcode.cn/problems/delete-middle-node-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * */
class _02_03删除中间节点 {

  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
