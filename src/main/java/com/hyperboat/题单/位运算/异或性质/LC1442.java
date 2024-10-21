package com.hyperboat.题单.位运算.异或性质;

import java.util.HashMap;
import java.util.Map;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 * <p>
 * https://leetcode.cn/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/
 */
class LC1442 {

  public int countTriplets(int[] arr) {
    int n = arr.length;
    int ans = 0, xor = 0;
    Map<Integer, Integer> cnt = new HashMap<>();
    Map<Integer, Integer> sum = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int x = arr[i];
      if (cnt.containsKey(x ^ xor)) {
        ans += cnt.get(x ^ xor) * i - sum.get(x ^ xor);
      }
      cnt.merge(xor, 1, Integer::sum);
      sum.merge(xor, i, Integer::sum);
      xor ^= x;
    }
    return ans;
  }

}
