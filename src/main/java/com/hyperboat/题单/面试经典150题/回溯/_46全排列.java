package com.hyperboat.题单.面试经典150题.回溯;

import java.util.ArrayList;
import java.util.List;

public class _46全排列 {

  List<List<Integer>> res;
  boolean[] visit;

  public List<List<Integer>> permute(int[] nums) {
    res = new ArrayList<>();
    visit = new boolean[nums.length];
    dfs(0, new ArrayList<>(), nums);
    return res;
  }

  public void dfs(int index, List<Integer> line, int[] nums) {
    if (line.size() == nums.length) {
      res.add(new ArrayList<>(line));
      return;
    }
    for (int i = index; i < nums.length; i++) {
      if (visit[i]) {
        continue;
      }
      visit[i] = true;
      line.add(nums[i]);
      dfs(index++, line, nums);
      line.remove(line.size() - 1);
      visit[i] = false;
    }
  }
}
