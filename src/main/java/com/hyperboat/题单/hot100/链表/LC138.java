package com.hyperboat.题单.hot100.链表;

/**
 * 138. 随机链表的复制
 * <p>
 * https://leetcode.cn/problems/copy-list-with-random-pointer/description/
 */
class LC138 {

  public Node copyRandomList(Node head) {
    Node p = head;
    while (p != null) {
      Node newNode = new Node(p.val);
      newNode.next = p.next;
      p.next = newNode;
      p = newNode.next;
    }
    p = head;
    while (p != null) {
      if (p.random != null) {
        p.next.random = p.random.next;
      }
      p = p.next.next;
    }
    p = head;
    Node dummy = new Node(0);
    Node curr = dummy;
    while (p != null) {
      curr.next = p.next;
      curr = curr.next;
      p.next = curr.next;
      p = p.next;
    }
    return dummy.next;
  }

  class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }


}
