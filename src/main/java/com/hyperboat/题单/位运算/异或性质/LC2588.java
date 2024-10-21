package com.hyperboat.题单.位运算.异或性质;

import java.util.HashMap;
import java.util.Map;

/**
 * 2588. 统计美丽子数组数目
 * <p>
 * https://leetcode.cn/problems/count-the-number-of-beautiful-subarrays/description/
 */
class LC2588 {

  public long beautifulSubarrays(int[] nums) {
    long ans = 0L;
    int xor = 0;
    Map<Integer, Integer> cnt = new HashMap<>();
    cnt.put(xor, 1);
    for (int x : nums) {
      xor ^= x;
      ans += cnt.getOrDefault(xor, 0);
      cnt.merge(xor, 1, Integer::sum);
    }
    return ans;
  }

}
