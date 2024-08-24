package com.hyperboat.hot100.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _51_N皇后 {

  class Solution {

    private List<List<String>> res;
    private int n;
    private boolean[] rows;
    private boolean[] clos;
    private boolean[] l2r;
    private boolean[] r2l;
    private char[] mask;

    public List<List<String>> solveNQueens(int n) {
      res = new ArrayList<>();
      this.n = n;
      rows = new boolean[n];
      clos = new boolean[n];
      l2r = new boolean[n * 2];
      r2l = new boolean[n * 2];
      mask = new char[n];
      Arrays.fill(mask, '.');
      backTrace(0, new ArrayList<>());
      return res;
    }

    private void backTrace(int row, List<String> line) {
      if (row == n) {
        res.add(new ArrayList<>(line));
        return;
      }
      for (int i = 0; i < n; i++) {
        int l2rIndex = row - i + n - 1;
        if (!rows[row] && !clos[i] && !l2r[l2rIndex] && !r2l[row + i]) {
          rows[row] = clos[i] = l2r[l2rIndex] = r2l[row + i] = true;
          char[] chars = Arrays.copyOf(mask, n);
          chars[i] = 'Q';
          line.add(new String(chars));
          backTrace(row + 1, line);
          line.remove(line.size() - 1);
          rows[row] = clos[i] = l2r[l2rIndex] = r2l[row + i] = false;
        }
      }
    }

  }
}
