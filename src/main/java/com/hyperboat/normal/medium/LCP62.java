package com.hyperboat.normal.medium;

import java.util.HashSet;
import java.util.Set;

public class LCP62 {

  class Solution {

    public int transportationHub(int[][] path) {
      int[] degree = new int[1001];
      Set<Integer> set = new HashSet<>();
      for (int[] ints : path) {
        int a = ints[0];
        int b = ints[1];
        degree[a]--;
        degree[b]++;
        set.add(a);
        set.add(b);
      }
      for (Integer x : set) {
        if (degree[x] == set.size() - 1) {
          return x;
        }
      }
      return -1;
    }
  }
}
