package com.hyperboat.竞赛.周赛418;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.cn/contest/weekly-contest-418/problems/remove-methods-from-project/description/
 * */
public class Q2_移除可疑的方法 {

  static class Solution {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
      Set<Integer> all = new HashSet<>();
      for (int i = 0; i < n; i++) {
        all.add(i);
      }
      Set<Integer> bugs = new HashSet<>();
      bugs.add(k);
      Map<Integer, List<Integer>> inDegree = new HashMap<>();
      Map<Integer, List<Integer>> outDegree = new HashMap<>();
      Deque<Integer> dq = new ArrayDeque<>();
      for (int[] m : invocations) {
        inDegree.computeIfAbsent(m[1], key -> new ArrayList<>());
        inDegree.get(m[1]).add(m[0]);
        outDegree.computeIfAbsent(m[0], key -> new ArrayList<>());
        outDegree.get(m[0]).add(m[1]);
        if (m[0] == k) {
          dq.offer(m[1]);
        }
      }
      while (!dq.isEmpty()) {
        Integer poll = dq.poll();
        bugs.add(poll);
        List<Integer> list = outDegree.get(poll);
        if (list != null) {
          for (Integer x : list) {
            if (!bugs.contains(x)) {
              dq.offer(x);
            }
          }
        }
      }
      boolean canRemove = true;
      for (Integer bug : bugs) {
        List<Integer> list = inDegree.get(bug);
        if (list != null) {
          canRemove = bugs.containsAll(list);
          if (!canRemove) {
            break;
          }
        }
      }
      if (canRemove) {
        all.removeAll(bugs);
      }
      return new ArrayList<>(all);
    }
  }

}
