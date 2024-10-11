package com.hyperboat.题单.位运算.异或性质;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.cn/problems/count-pairs-of-points-with-distance-k/description/
 * */
public class _2857_统计距离为k的点对 {

  class Solution {

    public int countPairs(List<List<Integer>> c, int k) {
      Map<Long, Integer> cnt = new HashMap<>();
      int ans = 0;
      for (List<Integer> list : c) {
        int x = list.get(0);
        int y = list.get(1);
        for (int i = 0; i <= k; i++) {
          ans += cnt.getOrDefault((x ^ i) * 2000000L + (y ^ (k - i)), 0);
        }
        cnt.merge(x * 2000000L + y, 1, Integer::sum);
      }
      return ans;
    }
  }
}
