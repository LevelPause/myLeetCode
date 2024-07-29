package com.hyperboat.medium.剑指Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

/**
 * @author zhangweigang
 * @date 2022年06月18日 20:18 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素insertVal ，使这个列表仍然是循环升序的。
 * <p>
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 * <p>
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * <p>
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 * <p>
 */
public class _029排序的循环链表 {

  public Node insert(Node head, int insertVal) {
    Node node = new Node(insertVal);
    if (head == null) {
      node.next = node;
      return node;
    }
    if (head.next == head) {
      node.next = head.next;
      head.next = node;
      return head;
    }
    Node curr = head;
    Node next = head.next;
    //下一个游标是head时跳出循环
    while (next != head) {
      //大于等于当前且小于下一个
      if (insertVal >= curr.val && insertVal <= next.val) {
        break;
      }
      //到尾部了
      if (curr.val > next.val) {
        //大于等于当前或小于头部
        if (insertVal > curr.val || insertVal < next.val) {
          break;
        }
      }
      //游标后移一位
      curr = curr.next;
      next = next.next;
    }
    //将node插入到当前游标后面
    curr.next = node;
    node.next = next;
    return head;
  }

  public static class Node {

    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
      next = this;
    }

    public Node(int _val, Node _next) {
      val = _val;
      next = _next;
    }

    public int[] values() {
      Node curr = this;
      List<Integer> ints = new ArrayList<>();
      ints.add(curr.val);
      while (curr.next != this) {
        ints.add(curr.next.val);
        curr = curr.next;
      }
      return ints.stream().mapToInt(value -> value).toArray();
    }

    public static Node of(Integer... vals) {
      if (vals == null || vals.length == 0) {
        return null;
      }
      Node node = new Node(vals[0]);
      Node curr = node;
      for (int i = 0; i < vals.length - 1; i++) {
        curr.next = new Node(vals[i + 1]);
        curr = curr.next;
        if (i == vals.length - 2) {
          curr.next = node;
        }
      }
      return node;
    }
  }

  public static void main(String[] args) {
    System.out.println(Node.of(1, 2, 3, 4).values());
  }
}


