package com.hyperboat.面试经典150题.链表;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hyperboat.题单.面试经典150题.链表._146LRU缓存;
import org.junit.jupiter.api.Test;

class _146LRU缓存Test {

  @Test
  void test() {
    _146LRU缓存 lru = new _146LRU缓存(2);
    lru.put(1, 1); // 缓存是 {1=1}
    lru.put(2, 2); // 缓存是 {1=1, 2=2}
    assertEquals(1, lru.get(1));    // 返回 1
    lru.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
    assertEquals(-1, lru.get(2));    // 返回 -1 (未找到)
    lru.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
    assertEquals(-1, lru.get(1));    // 返回 -1 (未找到)
    assertEquals(3, lru.get(3));    // 返回 3
    assertEquals(4, lru.get(4));    // 返回 4
  }
}