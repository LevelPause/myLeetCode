package com.hyperboat.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月19日 2:36
 */
public class LC122买卖股票的最佳时机II {

  //贪心算法，核心是每次涨价就抛售,一涨就抛售。关注眼前
  public int maxProfit(int[] prices) {
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      maxProfit += Math.max(prices[i] - prices[i - 1], 0);
    }
    return maxProfit;

  }

  //dp 这个抉择有四个分支, 在i这一天我持有股票/没持有股票, 抛售股票/不抛售股票
  //四种分支的话一维数组无法表示,可以用二维数组dp[i][j]表示在i这一天的最大利润 j==0/1表示是否持有股票
  public int maxProfit1(int[] prices) {

    int length = prices.length;
    if (length <= 1) {
      return 0;
    }
    int[][] dp = new int[length][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < length; i++) {
      //没有持有股票在第i天能拿到的最大收益
      //dp[i - 1][1] + prices[i]表示抛售(手里有股票才能抛售,所以是dp[i - 1][1])
      //dp[i - 1][0]表示不作为,继承上次状态
      dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
      //持有股票在第i天能拿到的最大收益
      //dp[i - 1][0] - prices[i]表示收购(手里没有股票才能收购,所以是dp[i - 1][0])
      //dp[i - 1][1]表示不作为,继承上次状态
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[length - 1][0];
  }

  //dp优化空间 可以用滚动覆盖将dp数组的空间节省掉
  public int maxProfit2(int[] prices) {

    int length = prices.length;
    if (length <= 1) {
      return 0;
    }
    int sale = 0;
    int hold = -prices[0];
    for (int i = 1; i < length; i++) {
      //没有持有股票在第i天能拿到的最大收益
      sale = Math.max(hold + prices[i], sale);
      //持有股票在第i天能拿到的最大收益
      hold = Math.max(hold, sale - prices[i]);
    }
    return sale;
  }
}
