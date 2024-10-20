package com.hyperboat.题单.面试经典150题.图;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.cn/problems/evaluate-division/?envType=study-plan-v2&envId=top-interview-150
 * */
class _399除法求值 {

  Map<String, Integer> map = new HashMap<>();

  public double[] ca_Equation(List<List<String>> equations, double[] values,
      List<List<String>> queries) {
    int count = 0;

    for (List<String> equation : equations) {
      String a = equation.get(0);
      String b = equation.get(1);
      if (!map.containsKey(a)) {
        map.put(a, count++);
      }
      if (!map.containsKey(b)) {
        map.put(b, count++);
      }
    }

    UnionFind uf = new UnionFind(count);

    for (int i = 0; i < equations.size(); i++) {
      List<String> item = equations.get(i);
      String l = item.get(0);
      String r = item.get(1);
      double value = values[i];
      uf.union(map.get(l), map.get(r), value);
    }

    double[] res = new double[queries.size()];

    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      String l = query.get(0);
      String r = query.get(1);
      if (!map.containsKey(l) || !map.containsKey(r)) {
        res[i] = -1.0d;
      } else {
        res[i] = uf.getWeight(map.get(l), map.get(r));
      }
    }
    return res;
  }

  class UnionFind {

    int parents[];
    double weights[];

    public UnionFind(int n) {
      parents = new int[n];
      weights = new double[n];
      for (int i = 0; i < n; i++) {
        parents[i] = i;
        weights[i] = 1.0d;
      }
    }

    public int find(int i) {
      if (i != parents[i]) {
        int pI = find(parents[i]);
        weights[i] = weights[i] * weights[parents[i]];
        parents[i] = pI;
      }
      return parents[i];
    }

    public void union(int a, int b, double value) {
      int ar = find(a);
      int br = find(b);
      parents[ar] = br;
      weights[ar] = weights[b] * value / weights[a];
    }

    public double getWeight(int a, int b) {
      int ar = find(a);
      int br = find(b);
      if (ar != br) {
        return -1.0d;
      } else {
        return weights[a] / weights[b];
      }
    }
  }
}
