package com.hyperboat.daily.y2024.m07.d30;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC2961 {

  public List<Integer> getGoodIndices(int[][] variables, int target) {
    Set<Integer> ans = new HashSet<>();
    for (int i = 0; i < variables.length; i++) {
      int a = variables[i][0];
      int b = variables[i][1];
      int c = variables[i][2];
      int m = variables[i][3];
      int val = pow(pow(a, b, 10), c, m);
      if (val == target) {
        ans.add(i);
      }
    }
    return new ArrayList<>(ans);
  }

  public int pow(int a, int n, int mod) {
    int ans = 1;
    while (n > 0) {
      if ((n & 1) == 1) {
        ans = ans * a % mod;
      }
      a = a * a % mod;
      n = n >> 1;
    }
    return ans;
  }
}
