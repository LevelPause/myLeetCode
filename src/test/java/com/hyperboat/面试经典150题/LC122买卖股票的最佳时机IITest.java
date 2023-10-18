package com.hyperboat.面试经典150题;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月19日 2:37
 */
class LC122买卖股票的最佳时机IITest {

  @Test
  void maxProfit() {
    assertEquals(7, new LC122买卖股票的最佳时机II().maxProfit(new int[]{7,1,5,3,6,4}));
    assertEquals(7, new LC122买卖股票的最佳时机II().maxProfit1(new int[]{7,1,5,3,6,4}));
    assertEquals(7, new LC122买卖股票的最佳时机II().maxProfit2(new int[]{7,1,5,3,6,4}));
  }
}