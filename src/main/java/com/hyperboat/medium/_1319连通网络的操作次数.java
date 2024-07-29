package com.hyperboat.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1319连通网络的操作次数 {
//  并查集，总需要绳子数==每个连通量最少需要绳子数+链接连通量需要绳子数
//  操作次数==连通量-1；

  public int makeConnected(int n, int[][] connections) {
    UnionFind uf = new UnionFind(n);
    for (int[] connection : connections) {
      uf.union(connection[0], connection[1]);
    }
    Map<Integer, Integer> groupMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int root = uf.find(i);
      groupMap.putIfAbsent(root, uf.getSize(root));
    }
    int lineCount = connections.length;
    for (Integer value : groupMap.values()) {
      lineCount -= value - 1;
    }
    return lineCount < (groupMap.size() - 1) ? -1 : groupMap.size() - 1;
  }

  class UnionFind {

    int[] parents;
    int[] sizes;

    public UnionFind(int n) {
      parents = new int[n];
      sizes = new int[n];
      for (int i = 0; i < parents.length; i++) {
        parents[i] = i;
      }
      Arrays.fill(sizes, 1);
    }

    public int find(int index) {
      if (parents[index] != index) {
        parents[index] = find(parents[index]);
      }
      return parents[index];
    }

    public void union(int index1, int index2) {
      int root1 = find(index1);
      int root2 = find(index2);
      if (root1 == root2) {
        return;
      }
      if (sizes[root1] < sizes[root2]) {
        sizes[root2] += sizes[root1];
        parents[root1] = root2;
      } else {
        sizes[root1] += sizes[root2];
        parents[root2] = root1;
      }
    }

    public int getSize(int index) {
      return sizes[index];
    }
  }
}
