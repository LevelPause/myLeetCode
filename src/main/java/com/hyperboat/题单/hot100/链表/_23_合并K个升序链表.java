package com.hyperboat.题单.hot100.链表;

public class _23_合并K个升序链表 {

  static class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
        return null;
      }
      return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int l, int r) {
      if (l == r) {
        return lists[l];
      }
      if (l == r - 1) {
        return merge(lists[l], lists[r]);
      }
      int m = (l + r) >> 1;
      ListNode lNode = mergeKLists(lists, l, m);
      ListNode rNode = mergeKLists(lists, m + 1, r);
      return merge(lNode, rNode);
    }

    public ListNode merge(ListNode l, ListNode r) {
      ListNode dummy = new ListNode(0);
      ListNode curr = dummy;
      while (l != null && r != null) {
        if (l.val < r.val) {
          curr.next = l;
          l = l.next;
        } else {
          curr.next = r;
          r = r.next;
        }
        curr = curr.next;
      }
      curr.next = l != null ? l : r;
      return dummy.next;
    }
  }

  static class ListNode {

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
