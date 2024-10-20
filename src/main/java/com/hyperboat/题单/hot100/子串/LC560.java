package com.hyperboat.题单.hot100.子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * <p>
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/
 */
class LC560 {

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
