package com.hyperboat.daily.y2024.m07.d26;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/find-the-value-of-the-partition/?envType=daily-question&envId=2024-07-26
 * */
public class LC2740 {

  //贪心 找出两个数的最小差(绝对值)
  public int findValueOfPartition(int[] nums) {
    Arrays.sort(nums);
    int res = Integer.MAX_VALUE;
    for (int i = 1; i < nums.length; i++) {
      res = Math.min(res, nums[i] - nums[i - 1]);
    }
    return res;
  }
}
