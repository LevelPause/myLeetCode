package com.hyperboat.题单.位运算.基础;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/sort-integers-by-the-number-of-1-bits/description/
 * */
public class _1356_根据数字二进制下1的数目排序 {

  class Solution {

    public int[] sortByBits(int[] arr) {
      int[] bit = new int[10001];
      for (int i = 1; i <= 10000; i++) {
        bit[i] = bit[i >> 1] + (i & 1);
      }
      return Arrays.stream(arr).boxed()
          .sorted((o1, o2) -> {
            int cnt1 = bit[o1];
            int cnt2 = bit[o2];
            if (cnt1 != cnt2) {
              return cnt1 - cnt2;
            } else {
              return o1 - o2;
            }
          }).mapToInt(
              value -> value).toArray();
    }
  }
}
