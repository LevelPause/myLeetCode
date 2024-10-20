package com.hyperboat.题单.dp._3_背包._3_1_01背包;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3180. 执行操作可获得的最大总奖励I
 * <p>
 * https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/
 */
class LC3180 {

  // 01背包 bitset

  public int maxTotalReward(int[] rewardValues) {
    int max = 0;
    for (int x : rewardValues) {
      max = Math.max(max, x);
    }
    Set<Integer> set = new HashSet<>();
    for (int x : rewardValues) {
      if (x == max - 1) {
        return max + max - 1;
      }
      if (set.contains(x)) {
        continue;
      }
      if (set.contains(max - 1 - x)) {
        return max + max - 1;
      }
      set.add(x);
    }
    Arrays.sort(rewardValues);
    BigInteger dp = BigInteger.ONE;
    int pre = 0;
    for (int x : rewardValues) {
      if (pre == x) {
        continue;
      }
      BigInteger mask = BigInteger.ONE.shiftLeft(x).subtract(BigInteger.ONE);
      dp = dp.or(dp.and(mask).shiftLeft(x));
      pre = x;
    }
    return dp.bitLength() - 1;
  }

}
