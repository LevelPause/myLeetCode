package com.hyperboat.题单.程序员面试金典.链表;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 * <p>
 * https://leetcode.cn/problems/remove-duplicate-node-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
class LCI0201 {

  public ListNode removeDuplicateNodes(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(head.val);
    dummy.next = head;
    ListNode curr = head;
    Set<Integer> set = new HashSet<>();
    set.add(curr.val);
    while (curr.next != null) {
      if (set.contains(curr.next.val)) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
        set.add(curr.val);
      }
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
