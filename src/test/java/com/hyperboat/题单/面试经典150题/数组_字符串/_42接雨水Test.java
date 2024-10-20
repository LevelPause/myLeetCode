package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月21日
 */
class _42接雨水Test {

  @Test
  void trap() {
//    assertEquals(6, new _42接雨水().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    assertEquals(9, new _42接雨水().trap(new int[]{4,2,0,3,2,5}));
  }
}