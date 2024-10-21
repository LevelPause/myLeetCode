package com.hyperboat.题单.程序员面试金典.链表;

/**
 * 面试题 02.08. 环路检测
 * <p>
 * https://leetcode.cn/problems/linked-list-cycle-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
class LCI0208 {

  // 数学证明： 设起点到入环点距离为a, 环长为b, 相遇点距离入环点还剩c
//  快指针的里程S1=a+(n+1)b+(b-c)
//  慢指针的里程S2=a+n*b+b-c
//  S1=2*S2 S1=b+S2  => S1 = 2*S1-2*b => S1 =2*b
//  所以 2(a+n*c+b-c) = a+(n+1)c+b-c
//  得a+b-c =b  => a=c
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode fast = head;
    ListNode slow = head;
    //快慢指针，相遇时快指针比慢指针多跑一圈
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) {
        break;
      }
    }
    //如果没有相遇，代表无环
    if (fast != slow) {
      return null;
    }
    //第一次相遇的地方与入环点的距离==起点与入环点的距离
    fast = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
