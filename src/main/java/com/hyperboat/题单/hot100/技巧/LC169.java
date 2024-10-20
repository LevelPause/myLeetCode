package com.hyperboat.题单.hot100.技巧;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * <p>
 * https://leetcode.cn/problems/majority-element/?envType=study-plan-v2&envId=top-100-liked
 */
class LC169 {

  public int majorityElement(int[] nums) {
    return vote(nums);
  }

  public int normal(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int num : nums) {
      cnt.merge(num, 1, Integer::sum);
      if (cnt.get(num) > n / 2) {
        return num;
      }
    }
    return -1;
  }

  public int vote(int[] nums) {
    int candidate = 0;
    int count = 0;
    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += candidate == num ? 1 : -1;
    }
    return candidate;
  }

}
