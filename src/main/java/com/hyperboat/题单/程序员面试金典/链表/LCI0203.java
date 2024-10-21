package com.hyperboat.题单.程序员面试金典.链表;

/**
 * 面试题 02.03. 删除中间节点
 * <p>
 * https://leetcode.cn/problems/delete-middle-node-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
class LCI0203 {

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
