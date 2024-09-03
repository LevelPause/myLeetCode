package com.hyperboat.题单.hot100.hash;

import java.util.HashMap;
import java.util.Map;

public class _1_两数之和 {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> num2Index = new HashMap<>();
    for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
      int num = nums[i];
      if (num2Index.containsKey(target - num)) {
        return new int[]{i, num2Index.get(target - num)};
      } else {
        num2Index.put(num, i);
      }
    }
    return new int[0];
  }
}
