package com.hyperboat.normal.medium;

class LC2492 {

  public int minScore(int n, int[][] roads) {
    int min = Integer.MAX_VALUE;
    UnionFind uf = new UnionFind(n);
    for (int[] road : roads) {
      uf.union(road[0] - 1, road[1] - 1);
    }
    int root1 = uf.find(0);
    for (int[] road : roads) {
      int lRoot = uf.find(road[0] - 1);
      if (root1 == lRoot) {
        min = Math.min(min, road[2]);
      }
    }
    return min;
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
