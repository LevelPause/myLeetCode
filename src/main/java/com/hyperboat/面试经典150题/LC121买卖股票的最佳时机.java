package com.hyperboat.面试经典150题;

/**
 * @author zhangweigang
 * @date 2023年10月19日 2:01
 */
public class LC121买卖股票的最佳时机 {

  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n <= 1) {
      return 0;
    }
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for (int price : prices) {
      minPrice = Math.min(minPrice, price);
      maxProfit = Math.max(maxProfit, price - minPrice);
    }
    return maxProfit;
  }
}
