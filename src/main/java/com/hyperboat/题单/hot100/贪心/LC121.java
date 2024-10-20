package com.hyperboat.题单.hot100.贪心;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 */
class LC121 {

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
