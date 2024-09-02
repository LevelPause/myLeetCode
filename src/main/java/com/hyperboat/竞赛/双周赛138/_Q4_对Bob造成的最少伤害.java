package com.hyperboat.竞赛.双周赛138;

import java.util.Arrays;

public class _Q4_对Bob造成的最少伤害 {

  static class Solution {

    public long minDamage(int power, int[] damage, int[] health) {
      long sumDamage = 0L;
      int n = damage.length;
      int[][] weight = new int[n][2];

      for (int i = 0; i < n; i++) {
        if (health[i] % power != 0) {
          health[i] = health[i] / power + 1;
        } else {
          health[i] /= power;
        }
        sumDamage += damage[i];
        weight[i][0] = health[i];
        weight[i][1] = damage[i];
      }

      Arrays.sort(weight, (o1, o2) -> o1[0] * o2[1] - o1[1] * o2[0]);

      long ans = 0L;
      for (int i = 0; i < n; i++) {
        ans += sumDamage * weight[i][0];
        sumDamage -= weight[i][1];
      }
      return ans;
    }
  }
}
