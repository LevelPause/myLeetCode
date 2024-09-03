package com.hyperboat.题单.面试经典150题.哈希表;

import java.util.HashMap;
import java.util.Map;

public class _1两数之和 {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[]{i, map.get(target - nums[i])};
      }
      map.put(nums[i], i);
    }
    return new int[2];
  }
}
