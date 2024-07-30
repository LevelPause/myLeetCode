package com.hyperboat.面试经典150题.分治;

/**
 *
 */
public class _148排序链表 {

  public ListNode sortList(ListNode head) {
    return sortList(head, null);
  }

  public ListNode sortList(ListNode head, ListNode tail) {
    if (head == null) {
      return null;
    }
    if (head.next == tail) {
      head.next = null;
      return head;
    }
    //利用快慢指针确定链表中间节点
    ListNode slow = head;
    ListNode fast = head;
    while (fast != tail) {
      fast = fast.next;
      slow = slow.next;
      if (fast != tail) {
        fast = fast.next;
      }
    }
    // 左右子节点分别排序，而后合并
    ListNode mid = slow;
    ListNode l = sortList(head, mid);
    ListNode r = sortList(mid, tail);
    return merge(l, r);
  }

  //将两个有序列表合并为一个有序列表
  public ListNode merge(ListNode l, ListNode r) {
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