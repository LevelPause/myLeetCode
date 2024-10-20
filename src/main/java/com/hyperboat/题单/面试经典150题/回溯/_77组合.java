package com.hyperboat.题单.面试经典150题.回溯;

import java.util.ArrayList;
import java.util.List;

class _77组合 {

  List<List<Integer>> res;

  public List<List<Integer>> combine(int n, int k) {
    res = new ArrayList<>();
    dfs(0, new ArrayList<>(), n, k);
    return res;
  }

  public void dfs(int index, List<Integer> line, int n, int k) {
    if (line.size() == k) {
      res.add(new ArrayList<>(line));
      return;
    }
    for (index++; index <= n; index++) {
      line.add(index);
      dfs(index, line, n, k);
      line.remove(line.size() - 1);
    }
  }
}
