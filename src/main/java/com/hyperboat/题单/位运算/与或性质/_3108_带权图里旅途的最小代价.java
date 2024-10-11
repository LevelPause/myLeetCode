package com.hyperboat.题单.位运算.与或性质;

/*
 * https://leetcode.cn/problems/minimum-cost-walk-in-weighted-graph/description/
 * */
public class _3108_带权图里旅途的最小代价 {

  class Solution {

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
      UnionFind uf = new UnionFind(n);
      for (int[] edge : edges) {
        uf.union(edge[0], edge[1], edge[2]);
      }
      int m = query.length;
      int[] ans = new int[m];
      for (int i = 0; i < m; i++) {
        int s = uf.find(query[i][0]);
        int t = uf.find(query[i][1]);
        ans[i] = s == t ? uf.weights[s] : -1;
      }
      return ans;
    }

    class UnionFind {

      int[] parents;
      int[] weights;

      public UnionFind(int n) {
        parents = new int[n];
        weights = new int[n];
        for (int i = 0; i < n; i++) {
          parents[i] = i;
          weights[i] = -1;
        }
      }

      public void union(int a, int b, int weight) {
        int x = find(a);
        int y = find(b);
        weights[y] &= weight;
        if (x != y) {
          parents[x] = y;
          weights[y] &= weights[x];
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
