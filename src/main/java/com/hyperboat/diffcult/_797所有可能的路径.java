package com.hyperboat.diffcult;

import java.util.ArrayList;
import java.util.List;

public class _797所有可能的路径 {

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    int n = graph.length;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    result.add(0);
    dfs(ans, result, 0, graph);
    return ans;
  }

  public void dfs(List<List<Integer>> ans, List<Integer> result, int i, int[][] graph) {
    if (i == graph.length - 1) {
      ans.add(new ArrayList<>(result));
      return;
    }
    for (int item : graph[i]) {
      result.add(item);
      dfs(ans, result, item, graph);
      result.remove(result.size() - 1);
    }
  }
}
