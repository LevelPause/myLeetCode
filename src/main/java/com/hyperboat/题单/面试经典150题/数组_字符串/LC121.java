package com.hyperboat.题单.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月19日 2:01
 */
class LC121 {

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
