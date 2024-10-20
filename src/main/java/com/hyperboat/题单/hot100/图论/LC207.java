package com.hyperboat.题单.hot100.图论;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 207. 课程表
 * <p>
 * https://leetcode.cn/problems/course-schedule/description/
 */
class LC207 {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses];
    List<List<Integer>> map = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      map.add(new ArrayList<>());
    }
    for (int[] item : prerequisites) {
      int a = item[0];
      int b = item[1];
      inDegree[a]++;
      map.get(b).add(a);
    }
    Deque<Integer> dq = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        dq.offerFirst(i);
      }
    }
    int visited = 0;
    while (!dq.isEmpty()) {
      visited++;
      Integer poll = dq.pollLast();
      for (Integer v : map.get(poll)) {
        if (--inDegree[v] == 0) {
          dq.offerFirst(v);
        }
      }
    }
    return visited == numCourses;
  }

}
