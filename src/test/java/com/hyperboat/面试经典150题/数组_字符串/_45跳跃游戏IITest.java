package com.hyperboat.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import com.hyperboat.题单.面试经典150题.数组_字符串._45跳跃游戏II;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月20日 1:45
 */
class _45跳跃游戏IITest {

  @Test
  void jump() {
    assertEquals(2, new _45跳跃游戏II().jump(new int[]{2, 3, 1, 1, 4}));
    assertEquals(1, new _45跳跃游戏II().jump2(new int[]{2, 1}));
  }
}