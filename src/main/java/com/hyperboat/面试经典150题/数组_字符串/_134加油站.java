package com.hyperboat.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月20日 23:23
 */
public class _134加油站 {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int sumGas = 0;
    int sumCost = 0;
    for (int i = 0; i < n; i++) {
      sumGas += gas[i];
      sumCost += cost[i];
    }
    if (sumCost > sumGas) {
      return -1;
    }
    int curr = gas[0];
    int index = 0;
    for (int i = 1; i < n; i++) {
      if (curr - cost[i - 1] < 0) {
        index = i;
        curr = gas[i];
      } else {
        curr += gas[i] - cost[i - 1];
      }
    }
    return index;
  }
}
