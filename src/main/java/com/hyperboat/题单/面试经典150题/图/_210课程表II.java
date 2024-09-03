package com.hyperboat.题单.面试经典150题.图;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _210课程表II {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses];
    List<List<Integer>> edges = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      edges.add(new ArrayList<>());
    }

    for (int[] item : prerequisites) {
      int l = item[0];
      int r = item[1];
      List<Integer> line = edges.get(r);
      line.add(l);
      inDegree[l]++;
    }
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < edges.size(); i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    int[] ans = new int[numCourses];
    int visited = 0;
    while (!queue.isEmpty()) {
      int pull = queue.poll();
      ans[visited] = pull;
      visited++;
      for (Integer k : edges.get(pull)) {
        if (--inDegree[k] == 0) {
          queue.offer(k);
        }
      }
    }
    return visited == numCourses ? ans : new int[0];

  }
}
