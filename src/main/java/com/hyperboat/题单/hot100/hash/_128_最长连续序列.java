package com.hyperboat.题单.hot100.hash;

import java.util.HashSet;
import java.util.Set;

public class _128_最长连续序列 {

  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int ans = 0;
    for (int x : nums) {
      if (!set.contains(x + 1)) {
        int count = 1;
        while (set.contains(x - 1)) {
          count++;
          x--;
        }
        ans = Math.max(count, ans);
      }
    }
    return ans;
  }
}
