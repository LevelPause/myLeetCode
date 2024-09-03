package com.hyperboat.题单.面试经典150题.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39组合总和 {

  List<List<Integer>> res;
  List<Integer> line;
  int[] candidates;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    res = new ArrayList<>();
    line = new ArrayList<>();
    Arrays.sort(candidates);
    this.candidates = candidates;
    dfs(0, target);
    return res;
  }

  /*
   * 方法1， 选哪个？
   * */
  public void dfs(int index, int target) {
    if (target == 0) {
      res.add(new ArrayList<>(line));
      return;
    }
    if (target < candidates[index]) {
      return;
    }
    for (int i = index; i < candidates[i]; i++) {
      line.add(candidates[i]);
      dfs(i, target - candidates[i]);
      line.remove(line.size() - 1);
    }
  }

  /*
   * 第二种  选不选   01背包
   * */
  public void dfs2(int index, int target) {
    if (target == 0) {
      res.add(new ArrayList<>(line));
      return;
    }
    if (index == candidates.length || target < candidates[index]) {
      return;
    }
    /*不选*/
    dfs(index + 1, target);
    /*选*/
    line.add(candidates[index]);
    dfs2(index, target - candidates[index]);
    line.remove(line.size() - 1);
  }
}
