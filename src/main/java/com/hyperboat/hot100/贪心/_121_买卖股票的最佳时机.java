package com.hyperboat.hot100.贪心;

public class _121_买卖股票的最佳时机 {

  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minPrice = prices[0];
    for (int i = 0; i < prices.length; i++) {
      maxProfit = Math.max(maxProfit, prices[i] - minPrice);
      minPrice = Math.min(minPrice, prices[i]);
    }
    return maxProfit;
  }
}
