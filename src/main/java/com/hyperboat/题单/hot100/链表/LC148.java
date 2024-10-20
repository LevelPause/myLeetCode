package com.hyperboat.题单.hot100.链表;

/**
 * 148. 排序链表
 * <p>
 * https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&envId=top-100-liked
 */
class LC148 {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0, head);
    ListNode fast = dummy;
    ListNode slow = dummy;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode nxt = slow.next;
    slow.next = null;
    ListNode l = sortList(head);
    ListNode r = sortList(nxt);
    return merge(l, r);
  }

  public ListNode merge(ListNode l, ListNode r) {
    ListNode dummy = new ListNode();
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
    if (l != null) {
      curr.next = l;
    }
    if (r != null) {
      curr.next = r;
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
