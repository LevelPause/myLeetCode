package com.hyperboat.daily.y2024.m09.d17;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC815 {

  static class Solution {

    public int numBusesToDestination(int[][] rs, int s, int t) {
      return s == t ? 0 : floyd(rs, s, t);
    }

    private int bfs(int[][] rs, int s, int t) {
      Map<Integer, List<Integer>> index = new HashMap<>();
      int n = rs.length;
      for (int i = 0; i < n; i++) {
        for (int x : rs[i]) {
          index.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
        }
      }
      if (!index.containsKey(s) || !index.containsKey(t)) {
        return s == t ? 0 : -1;
      }
      Map<Integer, Integer> path = new HashMap<>();
      Deque<Integer> dq = new LinkedList<>();
      dq.offer(s);
      path.put(s, 0);
      while (!dq.isEmpty()) {
        int poll = dq.poll();
        int step = path.get(poll);
        List<Integer> line = index.get(poll);
        for (Integer x : line) {
          if (rs[x] != null) {
            for (int i : rs[x]) {
              if (!path.containsKey(i)) {
                path.put(i, step + 1);
                dq.offer(i);
              }
            }
            rs[x] = null;
          }
        }
      }
      return path.getOrDefault(t, -1);
    }

    private int floyd(int[][] rs, int s, int t) {

      // 记录某个车站可以进入的路线
      Map<Integer, List<Integer>> map = new HashMap<>();
      // 队列存的是经过的路线
      Deque<Integer> d = new ArrayDeque<>();
      int n = rs.length;
      for (int i = 0; i < n; i++) {
        for (int station : rs[i]) {
          // 将从起点可以进入的路线加入队列
          if (station == s) {
            d.addLast(i);
          }
          List<Integer> list = map.getOrDefault(station, new ArrayList<>());
          list.add(i);
          map.put(station, list);
        }
      }

      int[][] dist = new int[n][n];
      for (int[] line : dist) {
        Arrays.fill(line, Integer.MAX_VALUE / 2);

      }
      for (List<Integer> line : map.values()) {
        int size = line.size();
        for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
            int x = line.get(i);
            int y = line.get(j);
            dist[x][y] = i == j ? 0 : 1;
          }
        }
      }
      for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
          }
        }
      }
      System.out.println(Arrays.deepToString(dist));
      int ans = -1;
      List<Integer> sList = map.get(s);
      List<Integer> tList = map.get(t);
      if (sList == null || tList == null) {
        return ans;
      }
      for (Integer x : sList) {
        for (Integer y : tList) {
          if (dist[x][y] == Integer.MAX_VALUE / 2) {
            continue;
          }
          if (ans == -1) {
            ans = dist[x][y] + 1;
          } else {
            ans = Math.min(ans, dist[x][y] + 1);
          }
        }
      }
      return ans;
    }
  }

}
