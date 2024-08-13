package com.hyperboat.diffcult;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1001网格照明 {

  public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
    long N = n;
    Map<Integer, Integer> rows = new HashMap<>();
    Map<Integer, Integer> cols = new HashMap<>();
    Map<Integer, Integer> l2rs = new HashMap<>();
    Map<Integer, Integer> r2ls = new HashMap<>();
    Set<Long> lights = new HashSet<>();
    int[][] masks = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1},
        {-1, 1}};

    for (int[] lamp : lamps) {
      int row = lamp[0];
      int col = lamp[1];
      incr(rows, row);
      incr(cols, col);
      incr(l2rs, row - col);
      incr(r2ls, row + col);
      lights.add(row * N + col);
    }

    int[] ans = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      int[] query = queries[i];
      int row = query[0];
      int col = query[1];
      if (rows.containsKey(row) || cols.containsKey(col) | l2rs.containsKey(row - col)
          || r2ls.containsKey(row + col)) {
        ans[i] = 1;
      }
      for (int[] m : masks) {
        int dx = row + m[0];
        int dy = col + m[1];
        if (lights.contains(dx * N + dy)) {
          lights.remove(dx * N + dy);
          decr(rows, dx);
          decr(cols, dy);
          decr(l2rs, dx - dy);
          decr(r2ls, dx + dy);
        }
      }
    }
    return ans;
  }

  public void incr(Map<Integer, Integer> map, int val) {
    map.put(val, map.getOrDefault(val, 0) + 1);
  }

  public void decr(Map<Integer, Integer> map, int val) {
    if (map.containsKey(val)) {
      if (map.get(val) == 1) {
        map.remove(val);
      } else {
        map.put(val, map.get(val) - 1);
      }
    }
  }
}
