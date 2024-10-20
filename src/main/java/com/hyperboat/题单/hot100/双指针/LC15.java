package com.hyperboat.题单.hot100.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * https://leetcode.cn/problems/3sum/description/
 */
class LC15 {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < n - 2; i++) {
      int x = nums[i];
      if (i > 0 && x == nums[i - 1]) {
        continue;
      }
      int l = i + 1;
      int r = n - 1;

      while (l < r) {
        int sum = x + nums[l] + nums[r];
        if (sum == 0) {
          res.add(Arrays.asList(x, nums[l], nums[r]));

          while (l < r && nums[l] == nums[l + 1]) {
            l++;
          }

          while (l < r && nums[r] == nums[r - 1]) {
            r--;
          }

          l++;
          r--;
        } else if (sum < 0) {
          l++;
        } else {
          r--;
        }
      }

    }

    return res;
  }
}
