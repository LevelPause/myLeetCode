package com.hyperboat.竞赛.周赛411;

public class Q2_超级饮料的最大强化能量 {

  public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
    int n = energyDrinkA.length;
    long dpA = energyDrinkA[0];
    long dpB = energyDrinkB[0];
    long dp0 = 0;
    for (int i = 1; i < n; i++) {
      long t = Math.max(dpA, dpB);
      dpA = Math.max(dp0, dpA) + energyDrinkA[i];
      dpB = Math.max(dp0, dpB) + energyDrinkB[i];
      dp0 = t;
    }
    return Math.max(Math.max(dpA, dpB), dp0);
  }
}
