package com.hyperboat.题单.程序员面试金典.树与图;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class _04_01节点间通路 {

  public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
//    邻接表
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] g : graph) {
      List<Integer> line = map.get(g[0]);
      if (line == null) {
        line = new ArrayList<>();
      }
      line.add(g[1]);
      map.put(g[0], line);
    }
    boolean[] visited = new boolean[n];
    Deque<Integer> qu = new ArrayDeque<>(map.get(start));
    while (!qu.isEmpty()) {
      Integer poll = qu.pollFirst();
      List<Integer> line = map.get(poll);
      if (line == null) {
        continue;
      }
      for (Integer v : line) {
        if (v == target) {
          return true;
        }
        if (visited[v]) {
          continue;
        }
        visited[v] = true;
        qu.offerLast(v);
      }
    }
    return false;
  }
}
