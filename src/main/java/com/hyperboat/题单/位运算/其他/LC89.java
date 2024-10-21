package com.hyperboat.题单.位运算.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 * <p>
 * https://leetcode.cn/problems/gray-code/description/
 */
class LC89 {

  public List<Integer> grayCode(int n) {
    var ans = new ArrayList<Integer>();
    for (int i = 0; i < 1 << n; i++) {
      ans.add(i >> 1 ^ i);
    }
    return ans;
  }

}
