package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月21日
 */
class LC135Test {

  @Test
  void candy() {
    assertEquals(5, new LC135().candy(new int[]{1, 0, 2}));
    assertEquals(7, new LC135().candy(new int[]{1,3,2,2,1}));
    assertEquals(18, new LC135().candy(new int[]{1,6,10,8,7,3,2}));
  }
}