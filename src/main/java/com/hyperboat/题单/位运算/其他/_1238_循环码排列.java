package com.hyperboat.题单.位运算.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/circular-permutation-in-binary-representation/description/
 */

class _1238_循环码排列 {

  class Solution {

    //获得格雷码然后逐个异或start
    public List<Integer> circularPermutation(int n, int start) {
      var ans = new ArrayList<Integer>();
      for (int i = 0; i < 1 << n; i++) {
        ans.add((i & i >> 1) & start);
      }
      return ans;
    }
  }
}
