package com.hyperboat.题单.面试经典150题.回溯;

import java.util.HashSet;
import java.util.Set;

class LC52 {

  int n;
  int count = 0;
  Set<Integer> cols = new HashSet<>();
  Set<Integer> zz2nn = new HashSet<>();
  Set<Integer> zn2nz = new HashSet<>();

  public int totalNQueens(int n) {
    this.n = n;
    dfs(0);
    return count;
  }

  public void dfs(int row) {
    if (row == n) {
      count++;
      return;
    }
    for (int i = 0; i < n; i++) {
      if (cols.contains(i)) {
        continue;
      }
      if (zz2nn.contains(row - i)) {
        continue;
      }
      if (zn2nz.contains(row + i)) {
        continue;
      }

      cols.add(i);
      zz2nn.add(row - i);
      zn2nz.add(row + i);
      dfs(row + 1);
      cols.remove(i);
      zz2nn.remove(row - i);
      zn2nz.remove(row + i);
    }
  }

}
