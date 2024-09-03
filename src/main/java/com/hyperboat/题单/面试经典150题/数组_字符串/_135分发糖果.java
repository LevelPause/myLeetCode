package com.hyperboat.题单.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月21日
 */
public class _135分发糖果 {

  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] left = new int[n];
    left[0] = 1;
    for (int i = 1; i < n; i++) {
      left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
    }
    int res = 0;
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
      if (i != n - 1) {
        right = ratings[i] > ratings[i + 1] ? right + 1 : 1;
      }
      res += Math.max(left[i], right);
    }
    return res;
  }
}
