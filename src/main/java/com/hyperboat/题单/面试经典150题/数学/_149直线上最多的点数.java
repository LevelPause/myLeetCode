package com.hyperboat.题单.面试经典150题.数学;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.cn/problems/max-points-on-a-line/?envType=study-plan-v2&envId=top-interview-150
 * */
class _149直线上最多的点数 {

  public int maxPoints(int[][] points) {
    int n = points.length;
    if (n == 1) {
      return 1;
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      Map<String, Set<Integer>> slopes = new HashMap<>();
      for (int j = i + 1; j < n; j++) {
        int dx = points[j][0] - points[i][0];
        int dy = points[j][1] - points[i][1];
        int k = gcd(dx, dy);
        String slope = (dx / k) + "_" + (dy / k);
        Set<Integer> set = slopes.get(slope);
        if (set == null) {
          set = new HashSet<>();
        }
        set.add(i);
        set.add(j);
        slopes.put(slope, set);
        ans = Math.max(ans, set.size());
      }
    }
    return ans;
  }

  public int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
