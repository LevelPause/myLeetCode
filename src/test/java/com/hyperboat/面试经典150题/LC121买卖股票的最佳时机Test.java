package com.hyperboat.面试经典150题;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2023年10月19日 2:08
 */
class LC121买卖股票的最佳时机Test {

  @Test
  void maxProfit() {
    assertEquals(5, new LC121买卖股票的最佳时机().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
  }
}