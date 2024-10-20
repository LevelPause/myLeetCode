package com.hyperboat.daily.y2024.m08.d17;

import java.util.HashMap;
import java.util.Map;

class LC3137 {

  class Solution {

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
      Map<String, Integer> map = new HashMap<>();
      int n = word.length();
      int max = 0;
      for (int i = k; i < n; i += k) {
        String str = word.substring(i - k, i);
        int cnt = map.merge(str, 1, Integer::sum);
        max = Math.max(max, cnt);
      }
      return n / k - max;
    }
  }
}
