package com.hyperboat.题单.面试经典150题.数组_字符串;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月19日 2:37
 */
class LC122Test {

  @Test
  void maxProfit() {
    assertEquals(7, new LC122().maxProfit(new int[]{7,1,5,3,6,4}));
    assertEquals(7, new LC122().maxProfit1(new int[]{7,1,5,3,6,4}));
    assertEquals(7, new LC122().maxProfit2(new int[]{7,1,5,3,6,4}));
  }
}