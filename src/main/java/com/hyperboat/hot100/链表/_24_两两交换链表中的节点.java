package com.hyperboat.hot100.链表;

public class _24_两两交换链表中的节点 {

  /*
   * https://leetcode.cn/problems/swap-nodes-in-pairs/?envType=study-plan-v2&envId=top-100-liked
   * */
  public ListNode swapPairs(ListNode head) {

    ListNode dummy = new ListNode(0, head);
    ListNode curr = dummy;
    while (curr.next != null && curr.next.next != null) {
      ListNode l = curr.next;
      ListNode r = curr.next.next;
      curr.next = r;
      l.next = r.next;
      r.next = l;
      curr = l;
    }
    return dummy.next;
  }

  public ListNode dfs(ListNode node) {
    if (node == null || node.next == null) {
      return node;
    }
    ListNode newNode = node.next;
    node.next = dfs(newNode.next);
    newNode.next = node;
    return newNode;
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
