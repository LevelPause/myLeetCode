package com.hyperboat.题单.面试经典150题.区间;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150
class _228汇总区间 {

  public List<String> summaryRanges(int[] nums) {
    return groupCircle(nums);
  }

  /*
   * 方法1 普通遍历
   * */
  public List<String> normal(int[] nums) {
    List<String> res = new ArrayList<>();
    int n = nums.length;
    if (n == 1) {
      res.add(nums[0] + "");
    }
    int index = 0;
    for (int i = 1; i < n; i++) {
      if (nums[i - 1] + 1 != nums[i]) {
        if (i - index > 1) {
          res.add(nums[index] + "->" + nums[i - 1]);
        } else {
          res.add(nums[index] + "");
        }
        if (i == n - 1) {
          res.add(nums[i] + "");
        }
        index = i;
      } else if (i == n - 1) {
        res.add(nums[index] + "->" + nums[i]);
      }
    }
    return res;

  }

  /*
    方法2
    分组循环, 这样写不用处理边界
  */
  public List<String> groupCircle(int[] nums) {
    List<String> res = new ArrayList<>();
    int n = nums.length;
    int index = 0;
    while (index < n) {
      int low = index;
      index++;
      while (index < n && nums[index] == nums[index - 1] + 1) {
        index++;
      }
      int high = index - 1;
      StringBuffer sb = new StringBuffer(nums[low] + "");
      if (low < high) {
        sb.append("->").append(nums[high]);
      }
      res.add(sb.toString());
    }
    return res;

  }
}
