package com.hyperboat.题单.面试经典150题.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class _15三数之和 {

  //狗屎题目,一堆边界判断
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> row = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int start = i + 1;
      int end = nums.length - 1;
      int third = nums[i];
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      while (start < end) {
        int sumTwo = nums[start] + nums[end];
        if (sumTwo + third == 0) {
          if (res.size() <= 0
              || start == 0
              || end == nums.length - 1
              || nums[start - 1] != nums[start]
              || nums[end + 1] != nums[end]) {
            row.add(nums[start]);
            row.add(nums[end]);
            row.add(third);
            res.add(row);
            row = new ArrayList<>();
          }
          start++;
          end--;
        } else if (sumTwo + third < 0) {
          start++;
        } else {
          end--;
        }
      }
    }
    return res;
  }
}
