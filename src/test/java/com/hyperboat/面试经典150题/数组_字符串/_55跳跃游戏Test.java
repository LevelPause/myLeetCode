package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月19日 3:46
 */
class _55跳跃游戏Test {

  @Test
  void canJump() {
    assertTrue(new _55跳跃游戏().canJump(new int[]{2, 3, 1, 1, 4}));
    assertTrue(new _55跳跃游戏().canJump(new int[]{2,5,0,0}));
  }
}