package com.hyperboat.daily.y2024.m10.d21;

import java.util.Arrays;

public class LC910 {

  public int smallestRangeII(int[] nums, int k) {
    var n = nums.length;
    Arrays.sort(nums);
    var ans = nums[n - 1] - nums[0];
    for (var i = 0; i < n - 1; i++) {
      var x = nums[i];
      var y = nums[i + 1];
      var max = Math.max(nums[n - 1] - k, x + k);
      var min = Math.min(nums[0] + k, y - k);
      ans = Math.min(ans, max - min);
    }
    return ans;
  }
}
