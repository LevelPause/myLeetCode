package com.hyperboat.题单.hot100.图论;

import java.util.HashMap;
import java.util.Map;

public class _200_岛屿数量 {

  class Solution {

    public int numIslands(char[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int size = 0;
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '1') {
            map.put(i * n + j, size);
            size++;
          }
        }
      }
      UnionFind uf = new UnionFind(size);
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i > 0 && grid[i][j] == '1' && grid[i - 1][j] == '1') {
            uf.union(map.get(i * n + j), map.get((i - 1) * n + j));
          }
          if (j > 0 && grid[i][j] == '1' && grid[i][j - 1] == '1') {
            uf.union(map.get(i * n + j), map.get(i * n + j - 1));
          }
        }
      }
      return uf.getSize();
    }

    private class UnionFind {

      private final int[] parents;
      private int size;

      public UnionFind(int cap) {
        parents = new int[cap];
        for (int i = 0; i < parents.length; i++) {
          parents[i] = i;
        }
        size = cap;
      }

      public int getSize() {
        return size;
      }

      public void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
          parents[a] = bRoot;
          size--;
        }
      }

      public int find(int x) {
        if (parents[x] != x) {
          parents[x] = find(parents[x]);
        }
        return parents[x];
      }
    }
  }
}
