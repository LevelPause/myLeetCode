package com.hyperboat.题单.面试经典150题.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _22括号生成 {

  List<String> ans = new ArrayList<>();
  int n;
  char[] line;

  public List<String> generateParenthesis(int n) {
    this.n = n;
    line = new char[n * 2];
    backTrace(n, n, 0);
    return ans;
  }

  public void backTrace(int l, int r, int index) {
    if (l > r || index == n * 2) {
      return;
    }
    if (l == 0) {
      Arrays.fill(line, index, n * 2, ')');
      System.out.println(line);
      ans.add(new String(line));
      return;
    }

//    选左括号
    line[index] = '(';
    backTrace(l - 1, r, index + 1);
    //选右括号
    line[index] = ')';
    backTrace(l, r - 1, index + 1);
  }
}
