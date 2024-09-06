package com.hyperboat.题单.hot100.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _22_括号生成 {

  public static class Solution {

    private List<String> res;

    public List<String> generateParenthesis(int n) {
      res = new ArrayList<>();
      char[] arr = new char[n * 2];
      dfs(0, n, n, arr);
      return res;
    }

    private void dfs(int index, int l, int r, char[] arr) {
      if (l > r || index == arr.length) {
        return;
      }
      if (l == 0) {
        Arrays.fill(arr, index, arr.length, ')');
        res.add(new String(arr));
        return;
      }
      arr[index] = '(';
      dfs(index + 1, l - 1, r, arr);
      arr[index] = ')';
      dfs(index + 1, l, r - 1, arr);
    }

    private void backTrace(int left, StringBuilder line) {
      if (left == 0 && line.length() > 0) {
        res.add(line.toString());
        return;
      }
      int length = line.length();
      for (int i = 0; i <= length; i++) {
        line.insert(i, "()");
        if (!res.contains(line.toString())) {
          backTrace(left - 1, line);
        }
        line.delete(i, i + 2);
      }
    }
  }
}
