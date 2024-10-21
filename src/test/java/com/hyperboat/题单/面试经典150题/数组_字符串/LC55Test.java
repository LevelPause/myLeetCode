package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月19日 3:46
 */
class LC55Test {

  @Test
  void canJump() {
    assertTrue(new LC55().canJump(new int[]{2, 3, 1, 1, 4}));
    assertTrue(new LC55().canJump(new int[]{2,5,0,0}));
  }
}