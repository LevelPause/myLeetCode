package com.hyperboat.daily.y2024.m09.d09;

class LC2181 {

  class Solution {

    public ListNode mergeNodes(ListNode head) {
      int sum = 0;
      ListNode dummy = new ListNode(0);
      ListNode curr = dummy;
      head = head.next;
      while (head != null) {
        sum += head.val;
        if (head.val == 0) {
          curr.next = new ListNode(sum);
          curr = curr.next;
          sum = 0;
        }
        head = head.next;
      }
      return dummy.next;
    }

    //原地修改
    public ListNode mergeNodes2(ListNode head) {
      ListNode tail = head;
      ListNode curr = head.next;
      while (curr.next != null) {
        if (curr.val != 0) {
          tail.val += curr.val;
        } else {
          tail = tail.next;
          tail.val = 0;
        }
        curr = curr.next;
      }
      tail.next = null;
      return head;
    }
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
