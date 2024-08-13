package com.hyperboat.hot100.子串;

import java.util.HashMap;
import java.util.Map;

public class _560_和为K的子数组 {

  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int preSum = 0;
    int ans = 0;
    for (int num : nums) {
      preSum += num;
      if (map.containsKey(preSum - k)) {
        ans += map.get(preSum - k);
      }
      map.put(preSum, map.getOrDefault(preSum, 0) + 1);
    }
    return ans;
  }
}
