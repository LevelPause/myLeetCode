package com.hyperboat.daily.y2024.m7.d23;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/find-the-sum-of-subsequence-powers/description/
 * */
public class _3098求出所有子序列的能量和 {

  int[] nums;
  Map<String, Long> map;
  int mod = (int) (1e9 + 7);

  public int sumOfPowers(int[] nums, int k) {
    Arrays.sort(nums);
    this.nums = nums;
    map = new HashMap<>();
    return (int)dfs(nums.length-1,k,Integer.MAX_VALUE/2,Integer.MAX_VALUE/2);
  }

  public long dfs(int i, int rest, int pre, int min) {
    if (i + 1 < rest) {
      return 0;
    }
    if (rest == 0) {
      return min;
    }
    String key = i + "#" + rest + "#" + pre + "#" + min;
    if (map.containsKey(key)) {
      return map.get(key);
    }
    long res = 0L;
    res = (res + dfs(i - 1, rest, pre, min)) % mod;
    res = (res + dfs(i - 1, rest - 1, nums[i], Math.min(min, pre - nums[i]))) % mod;
    map.put(key, res);
    return res;
  }
}
