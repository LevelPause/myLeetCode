package com.hyperboat.hot100.链表;

import java.util.HashMap;
import java.util.Map;

public class _146_LRU缓存 {

  static class LRUCache {

    Node dummy = new Node(-1, -1);
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      map = new HashMap<>(capacity);
      dummy.pre = dummy;
      dummy.next = dummy;
    }

    public int get(int key) {
      if (!map.containsKey(key)) {
        return -1;
      } else {
        Node node = map.get(key);
        deleteOne(node);
        add2Head(node);
        return node.value;
      }
    }

    public void put(int key, int value) {
      if (!map.containsKey(key)) {
        Node newNode = new Node(key, value);
        add2Head(newNode);
        map.put(key, newNode);
        if (map.size() > capacity) {
          int deleteKey = dummy.pre.key;
          deleteOne(dummy.pre);
          map.remove(deleteKey);
        }
      } else {
        Node node = map.get(key);
        node.value = value;
        deleteOne(node);
        add2Head(node);
      }
    }

    public void add2Head(Node node) {
      node.pre = dummy;
      node.next = dummy.next;
      node.pre.next = node;
      node.next.pre = node;

    }

    public void deleteOne(Node node) {
      node.pre.next = node.next;
      node.next.pre = node.pre;
    }
  }

  static class Node {

    Node pre;
    Node next;
    int key;
    int value;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}
