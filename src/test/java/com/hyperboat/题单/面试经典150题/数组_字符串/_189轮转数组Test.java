package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月18日 12:47
 */
class _189轮转数组Test {

  @Test
  void rotate() {
    int[] ints = {2, 1};
    new _189轮转数组().rotate(ints, 1);
    assertArrayEquals(new int[]{1, 2}, ints);
    int[] ints1 = {1, 2, 3, 4, 5, 6, 7};
    new _189轮转数组().rotate1(ints1, 3);
    assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, ints1);
  }
}