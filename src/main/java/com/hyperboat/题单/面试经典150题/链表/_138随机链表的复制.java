package com.hyperboat.题单.面试经典150题.链表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
// Definition for a Node.
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
*/
class _138随机链表的复制 {

  public Node copyRandomList(Node head) {
    return normal(head);
  }

  // 用两个list记录原节点与新节点的相对位置，方便赋值random
  public Node useList(Node head) {
    List<Node> copiedNodes = new ArrayList<>();
    List<Node> headNodes = new ArrayList<>();
    Node dummy = new Node(0);
    Node curr = dummy;
    while (head != null) {
      curr = curr.next = new Node(head.val);
      curr.next = head.next;
      headNodes.add(head);
      copiedNodes.add(curr);
      head = head.next;
    }
    for (int i = 0; i < copiedNodes.size(); i++) {
      Node random = headNodes.get(i).random;
      if (random != null) {
        copiedNodes.get(i).random = copiedNodes.get(headNodes.indexOf(random));
      }
    }
    return dummy.next;

  }

  //用map记录新节点与原节点对应的位置，方便赋值random
  public Node useMap(Node head) {
    Map<Node, Node> source2Copy = new HashMap<>();
    Node dummy = new Node(0);
    Node curr = dummy;
    while (head != null) {
      curr = curr.next = new Node(head.val);
      curr.next = head.next;
      source2Copy.put(head, curr);
      head = head.next;
    }
    for (Node sourceNode : source2Copy.keySet()) {
      Node random = sourceNode.random;
      if (random != null) {
        source2Copy.get(sourceNode).random = source2Copy.get(random);
      }
    }
    return dummy.next;
  }

  // 三次循环完成复制
// 第一次在原节点后面添加新节点, 新节点赋值val和next
// 第二次给新节点赋值random
// 第三次将原节点与新节点分开(分成两条链表)
  public Node normal(Node head) {
    // 在原来的每个节点后面新家一个节点
    Node p = head;
    while (p != null) {
      Node newNode = new Node(p.val);
      newNode.next = p.next;
      p.next = newNode;
      p = newNode.next;
    }
    p = head;
    // 给新节点的random赋值
    while (p != null) {
      if (p.random != null) {
        p.next.random = p.random.next;
      }
      p = p.next.next;
    }
    // 将新节点一一取出来
    p = head;
    Node dummy = new Node(-1);
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
