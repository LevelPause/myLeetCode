package com.hyperboat.题单.位运算.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/gray-code/description/
 */
class _89_格雷编码 {

  class Solution {

    public List<Integer> grayCode(int n) {
      var ans = new ArrayList<Integer>();
      for (int i = 0; i < 1 << n; i++) {
        ans.add(i >> 1 ^ i);
      }
      return ans;
    }
  }
}
