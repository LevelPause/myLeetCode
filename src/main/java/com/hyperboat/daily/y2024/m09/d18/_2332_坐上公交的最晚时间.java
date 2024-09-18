package com.hyperboat.daily.y2024.m09.d18;

import java.util.Arrays;

public class _2332_坐上公交的最晚时间 {

  class Solution {

    public int latestTimeCatchTheBus(int[] b, int[] p, int cap) {
      Arrays.sort(b);
      Arrays.sort(p);
      int n = b.length;
      int m = p.length;
      int rest = cap;
      int j = 0;
      for (int k : b) {
        rest = cap;
        while (rest > 0 && j < m && k >= p[j]) {
          j++;
          rest--;
        }
      }
      j--;
      //先找到最后一个上车的乘客
      //如果最后一班车没满, 就从最后一班车的出发时刻往前遍历
      int ans = rest > 0 ? b[n - 1] : p[j];
      //往前找到没有乘客占据的时刻
      while (j >= 0 && ans == p[j]) {
        ans--;
        j--;
      }
      return ans;
    }
  }
}
