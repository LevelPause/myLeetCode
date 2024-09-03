package com.hyperboat.题单.hot100.回溯;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {

  class Solution {

    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      backTrace(new boolean[nums.length], nums, res, new ArrayList<>());
      return res;
    }

    public void backTrace(boolean[] visited, int[] nums, List<List<Integer>> res,
        List<Integer> line) {
      if (line.size() == nums.length) {
        res.add(new ArrayList<>(line));
        return;
      }
      for (int i = 0; i < nums.length; i++) {
        if (!visited[i]) {
          visited[i] = true;
          line.add(nums[i]);
          backTrace(visited, nums, res, line);
          line.remove(line.size() - 1);
          visited[i] = false;
        }
      }
    }
  }
}
