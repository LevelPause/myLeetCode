package com.hyperboat.normal.diffcult;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。
 * <p>
 * 实现 AllOne 类：
 * <p>
 * AllOne() 初始化数据结构的对象。
 * <p>
 * inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。
 * <p>
 * dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例保证：在减少计数前，key
 * 存在于数据结构中。
 * <p>
 * getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。
 * <p>
 * getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。
 *
 *
 * <p>
 * Your AllOne object will be instantiated and called as such:
 * <p>
 * AllOne obj = new AllOne();
 * <p>
 * obj.inc(key);
 * <p>
 * obj.dec(key);
 * <p>
 * String param_3 = obj.getMaxKey();
 * <p>
 * String param_4 = obj.getMinKey();
 * @author hyperboat
 * @date 2022年03月16日 0:44
 */
public final class LC432 {


  final Node root;
  final Map<String, Node> nodeMap;

  public LC432() {
    root = new Node();
    root.prev = root;
    root.next = root;
    nodeMap = new HashMap<>();
  }

  public void inc(String key) {
    if (nodeMap.containsKey(key)) {
      Node currNode = nodeMap.get(key);
      int currCount = currNode.count;
      Node nextNode = currNode.next;
      if (nextNode == root || currCount + 1 < nextNode.count) {
        nodeMap.put(key, currNode.insert(new Node(currCount + 1, key)));
      } else {
        nextNode.keys.add(key);
        nodeMap.put(key, nextNode);
      }
      currNode.keys.remove(key);
      if (currNode.keys.isEmpty()) {
        currNode.remove();
      }
    } else {
      Node nextNode = root.next;
      if (nextNode == root || nextNode.count > 1) {
        nodeMap.put(key, root.insert(new Node(1, key)));
      } else {
        nextNode.keys.add(key);
        nodeMap.put(key, nextNode);
      }
    }
  }

  public void dec(String key) {
    Node currNode = nodeMap.get(key);
    int currCount = currNode.count;
    if (currNode.count == 1) {
      nodeMap.remove(key);
    } else {
      Node prevNode = currNode.prev;
      if (prevNode == root || currCount - 1 > prevNode.count) {
        nodeMap.put(key, prevNode.insert(new Node(currCount - 1, key)));
      } else {
        prevNode.keys.add(key);
        nodeMap.put(key, prevNode);
      }
    }
    currNode.keys.remove(key);
    if (currNode.keys.isEmpty()) {
      currNode.remove();
    }
  }

  public String getMaxKey() {
    return root.prev != null ? root.prev.keys.iterator().next() : "";

  }

  public String getMinKey() {
    return root.next != null ? root.next.keys.iterator().next() : "";
  }

  static class Node {

    Node prev;
    Node next;
    int count;
    Set<String> keys;

    public Node() {
      this(0, "");
    }

    public Node(int count, String key) {
      this.count = count;
      this.keys = new HashSet<>();
      keys.add(key);
    }

    public Node insert(Node node) {
      node.prev = this;
      node.next = this.next;
      this.next.prev = node;
      this.next = node;
      return node;
    }

    public void remove() {
      this.prev.next = this.next;
      this.next.prev = this.prev;
    }
  }
}