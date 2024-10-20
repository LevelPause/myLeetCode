package com.hyperboat.normal.simple;

class LC1971 {

  public boolean validPath(int n, int[][] edges, int source, int destination) {
    UnionFind uf = new UnionFind(n);
    for (int i = 0; i < edges.length; i++) {
      uf.union(edges[i][0], edges[i][1]);
    }
    return uf.find(source) == uf.find(destination);
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
