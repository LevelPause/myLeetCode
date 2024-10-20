package com.hyperboat.题单.hot100.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * https://leetcode.cn/problems/subsets/description/
 */
class LC78 {

  private List<List<Integer>> res;
  private int[] nums;

  public List<List<Integer>> subsets(int[] nums) {
    res = new ArrayList<>();
    this.nums = nums;
    backTrace(0, new ArrayList<>());
    return res;
  }

  private void backTrace(int index, List<Integer> line) {
    int n = nums.length;
    if (index == n) {
      res.add(new ArrayList<>(line));
      return;
    }
    line.add(nums[index]);
    backTrace(index + 1, line);
    line.remove(line.size() - 1);
    backTrace(index + 1, line);

  }

}
