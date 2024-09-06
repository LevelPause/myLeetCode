package com.hyperboat.题单.面试经典150题.链表;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/lru-cache/?envType=study-plan-v2&envId=top-interview-150
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class _146LRU缓存 {

  Map<Integer, Node> map;
  int maxSize;
  Node dummy;

  public _146LRU缓存(int capacity) {
    maxSize = capacity;
    map = new HashMap<>(capacity);
    dummy = new Node(0, 0);
    dummy.pre = dummy;
    dummy.next = dummy;
  }

  public int get(int key) {
    Node node = getNode(key);
    return node != null ? node.val : -1;
  }


  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = getNode(key);
      node.val = value;
    } else {
      Node newNode = new Node(key, value);
      addFirst(newNode);
      map.put(key, newNode);
    }
    if (map.size() > maxSize) {
      Node oldest = dummy.pre;
      delete(oldest);
      map.remove(oldest.key);
    }

  }

  void delete(Node node) {
    node.next.pre = node.pre;
    node.pre.next = node.next;
  }

  Node getNode(int key) {
    Node node = map.get(key);
    if (node == null) {
      return null;
    }
    delete(node);
    addFirst(node);
    return node;
  }

  void addFirst(Node node) {
    node.pre = dummy;
    node.next = dummy.next;
    node.pre.next = node;
    node.next.pre = node;
  }

  class Node {

    Node next;
    Node pre;
    int val;
    int key;

    public Node(int key, int val) {
      this.val = val;
      this.key = key;
    }


  }
}


