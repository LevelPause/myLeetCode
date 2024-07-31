package com.hyperboat.面试经典150题.分治;

public class _23合并K个升序链表 {

  ListNode[] lists;

  public ListNode mergeKLists(ListNode[] lists) {
    this.lists = lists;
    if (lists == null || lists.length == 0) {
      return null;
    }
    return dfs(0, lists.length - 1);
  }

  public ListNode dfs(int start, int end) {
    if (start == end) {
      return lists[start];
    }
    if (start + 1 == end) {
      return mergeTwo(lists[start], lists[end]);
    }
    ListNode l = dfs(start, (start + end) / 2);
    ListNode r = dfs((start + end) / 2 + 1, end);
    return mergeTwo(l, r);
  }

  public ListNode mergeTwo(ListNode l, ListNode r) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    ListNode currL = l;
    ListNode currR = r;
    while (currL != null && currR != null) {
      if (currL.val < currR.val) {
        curr.next = currL;
        currL = currL.next;
      } else {
        curr.next = currR;
        currR = currR.next;
      }
      curr = curr.next;
    }
    if (currL != null) {
      curr.next = currL;
    } else {
      curr.next = currR;
    }
    return dummy.next;
  }


  class ListNode {

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
