package com.hyperboat.normal.medium;

import java.util.HashMap;
import java.util.Map;

class LC2316 {

  //  利用并查集将所有连通量计算出来，然后用总组合数[Cn2]-每个连通量中的组合数[Cx2]，得到结果
  public long countPairs(int n, int[][] edges) {
    UnionFind uf = new UnionFind(n);
    for (int[] edge : edges) {
      uf.union(edge[0], edge[1]);
    }
    Map<Integer, Long> countMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int parent = uf.find(i);
      countMap.compute(parent, (key, value) -> {
        if (value == null) {
          value = 0L;
        }
        return value + 1;
      });
    }
    long ans = (long) n * (n - 1) / 2;
    for (Long value : countMap.values()) {
      ans -= value * (value - 1) / 2;
    }
    return ans;
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
