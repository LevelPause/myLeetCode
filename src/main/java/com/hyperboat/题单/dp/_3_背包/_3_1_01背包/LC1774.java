package com.hyperboat.题单.dp._3_背包._3_1_01背包;

import java.util.Arrays;

/**
 * 1774. 最接近目标价格的甜点成本
 * <p>
 * https://leetcode.cn/problems/closest-dessert-cost/description/
 */
class LC1774 {

  public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
    int x = Arrays.stream(baseCosts).min().getAsInt();
    if (x >= target) {
      return x;
    }
    boolean[] dp = new boolean[target + 1];
    int res = target * 2 - x;
    for (int b : baseCosts) {
      if (b > target) {
        res = Math.min(res, b);
      } else {
        dp[b] = true;
      }
    }
    for (int t : toppingCosts) {
      for (int count = 0; count < 2; count++) {
        for (int i = target; i > 0; i--) {
          if (dp[i] && t + i > target) {
            res = Math.min(res, t + i);
          }
          if (i - t > 0) {
            dp[i] |= dp[i - t];
          }
        }
      }
    }
    for (int i = 0; i <= res - target; i++) {
      if (dp[target - i]) {
        return target - i;
      }
    }
    return res;
  }

}
