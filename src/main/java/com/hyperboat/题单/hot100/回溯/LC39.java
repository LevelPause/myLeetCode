package com.hyperboat.题单.hot100.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * <p>
 * https://leetcode.cn/problems/combination-sum/description/
 */
class LC39 {

  private List<List<Integer>> res;
  private int[] candidates;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    this.candidates = candidates;
    res = new ArrayList<>();
    backTrace(0, target, new ArrayList<>());
    return res;
  }

  private void backTrace(int index, int rest, List<Integer> line) {
    if (rest == 0) {
      res.add(new ArrayList<>(line));
    }
    if (rest < candidates[index]) {
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      line.add(candidates[i]);
      backTrace(i, rest - candidates[i], line);
      line.remove(line.size() - 1);
    }

  }

}
