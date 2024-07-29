package com.hyperboat.面试经典150题.图;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/number-of-islands/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _200岛屿数量 {

  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          count++;
          dfs(i, j, grid);
        }
      }
    }
    return count;
  }

  public void dfs(int i, int j, char[][] grid) {
    grid[i][j] = '0';
    if (i > 0 && grid[i - 1][j] == '1') {
      dfs(i - 1, j, grid);
    }
    if (i < grid.length - 1 && grid[i + 1][j] == '1') {
      dfs(i + 1, j, grid);
    }
    if (j > 0 && grid[i][j - 1] == '1') {
      dfs(i, j - 1, grid);
    }
    if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
      dfs(i, j + 1, grid);
    }
  }

  public int useUnionFind(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int count = 0;
    Map<String, Integer> ij2Index = new HashMap<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == '1') {
          String key = "i" + i + "j" + j;
          ij2Index.put(key, count);
          count++;
        }
      }
    }
    UnionFind uf = new UnionFind(ij2Index.size());
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == '1') {
          String key = "i" + i + "j" + j;
          int index = ij2Index.get(key);
          if (i < row - 1 && grid[i + 1][j] == '1') {
            String nextRowKey = "i" + (i + 1) + "j" + j;
            uf.union(index, ij2Index.get(nextRowKey));
          }
          if (j < col - 1 && grid[i][j + 1] == '1') {
            String nextColKey = "i" + i + "j" + (j + 1);
            uf.union(index, ij2Index.get(nextColKey));
          }
        }
      }
    }
    return uf.size;

  }

  class UnionFind {

    int[] parents;
    int size;

    public UnionFind(int n) {
      parents = new int[n];
      for (int i = 0; i < n; i++) {
        parents[i] = i;
      }
      size = n;
    }

    public int get(int index) {
      if (parents[index] != index) {
        return parents[index] = get(parents[index]);
      } else {
        return index;
      }
    }

    public void union(int i1, int i2) {
      int r1 = get(i1);
      int r2 = get(i2);
      if (r1 != r2) {
        parents[r1] = r2;
        size--;
      }
    }
  }
}
