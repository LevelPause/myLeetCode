package com.hyperboat.normal.medium;

public class _547省份数量 {

  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    UnionFind uf = new UnionFind(n);
    for (int i = 0; i < isConnected.length; i++) {
      for (int j = 0; j < isConnected[i].length; j++) {
        if (isConnected[i][j] == 1) {
          uf.union(i, j);
        }
      }
    }
    int res = 0;
    for (int k = 0; k < uf.parent.length; k++) {
      if (uf.parent[k] == k) {
        res++;
      }
    }
    return res;
  }

  class UnionFind {

    int[] parent;

    public UnionFind(int n) {
      parent = new int[n];
      for (int i = 0; i < parent.length; i++) {
        parent[i] = i;
      }
    }

    public int find(int index) {
      if (parent[index] != index) {
        parent[index] = find(parent[index]);
      }
      return parent[index];
    }

    public void union(int index1, int index2) {
      parent[find(index1)] = find(index2);
    }
  }
}
