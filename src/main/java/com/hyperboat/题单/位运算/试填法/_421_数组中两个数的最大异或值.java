package com.hyperboat.题单.位运算.试填法;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/description/
 * */
public class _421_数组中两个数的最大异或值 {

  class Solution {

    public int findMaximumXOR(int[] nums) {
      int max = 0;
      for (int x : nums) {
        max = Math.max(max, x);
      }
      int highBit = 31 - Integer.numberOfLeadingZeros(max);

      int ans = 0, mask = 0;
      Set<Integer> seen = new HashSet<>();
      for (int i = highBit; i >= 0; i--) { // 从最高位开始枚举
        seen.clear();
        mask |= 1 << i;
        int newAns = ans | (1 << i); // 这个比特位可以是 1 吗？
        for (int x : nums) {
          x &= mask; // 低于 i 的比特位置为 0
          if (seen.contains(newAns ^ x)) {
            ans = newAns; // 这个比特位可以是 1
            break;
          }
          seen.add(x);
        }
      }
      return ans;
    }
  }
}
