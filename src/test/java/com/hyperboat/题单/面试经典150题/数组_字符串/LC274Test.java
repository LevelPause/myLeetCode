package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月20日 4:00
 */
class LC274Test {

  @Test
  void hIndex() {
    assertEquals(3, new LC274().hIndex(new int[]{3, 0, 6, 1, 5}));
    assertEquals(1, new LC274().hIndex(new int[]{100}));
    assertEquals(1, new LC274().hIndex(new int[]{1, 1}));
    assertEquals(3, new LC274().hIndex(new int[]{1, 3, 1, 3, 100}));
    assertEquals(4, new LC274().hIndex(new int[]{6, 6, 4, 8, 4, 3, 3, 10}));
    assertEquals(2, new LC274().hIndex(new int[]{1, 2, 2}));
  }
}