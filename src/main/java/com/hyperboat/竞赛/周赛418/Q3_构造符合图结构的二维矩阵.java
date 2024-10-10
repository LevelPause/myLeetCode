package com.hyperboat.竞赛.周赛418;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.cn/contest/weekly-contest-418/problems/construct-2d-grid-matching-graph-layout/description/
 * */
public class Q3_构造符合图结构的二维矩阵 {

  class Solution {

    public int[][] constructGridLayout(int n, int[][] edges) {
      List<Integer>[] g = new ArrayList[n];
      Arrays.setAll(g, i -> new ArrayList<>());
      for (int[] e : edges) {
        int x = e[0];
        int y = e[1];
        g[x].add(y);
        g[y].add(x);
      }

      // 找一个度数最小的点
      int x = 0;
      for (int i = 0; i < g.length; i++) {
        if (g[i].size() < g[x].size()) {
          x = i;
        }
      }

      List<Integer> row = new ArrayList<>();
      row.add(x);
      int degSt = g[x].size(); // 起点的度数
      int pre = -1;
      do { // 注意题目保证 n >= 2，可以至少循环一次
        int nxt = -1;
        for (int y : g[x]) {
          if (y != pre && (nxt < 0 || g[y].size() < g[nxt].size())) {
            nxt = y;
          }
        }
        pre = x;
        x = nxt;
        row.add(x);
      } while (g[x].size() > degSt);

      int k = row.size();
      int[][] ans = new int[n / k][k];
      boolean[] vis = new boolean[n];
      for (int j = 0; j < k; j++) {
        x = row.get(j);
        ans[0][j] = x;
        vis[x] = true;
      }
      for (int i = 1; i < ans.length; i++) {
        for (int j = 0; j < k; j++) {
          for (int y : g[ans[i - 1][j]]) {
            // 上左右的邻居都访问过了，没访问过的邻居只会在下面
            if (!vis[y]) {
              vis[y] = true;
              ans[i][j] = y;
              break;
            }
          }
        }
      }
      return ans;
    }
  }
}
