package com.hyperboat.daily.y2024.m08.d13;

public class _3151_特殊数组I {

  public boolean isArraySpecial(int[] nums) {
    int n = nums.length;
    if (n < 2) {
      return true;
    }

    for (int i = 1; i < n; i++) {
      if ((nums[i] & 1) == (nums[i - 1] & 1)) {
        return false;
      }
    }

    return true;
  }
}
