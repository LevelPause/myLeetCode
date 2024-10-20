package com.hyperboat.题单.位运算.思维题;

/**
 * https://leetcode.cn/problems/apply-bitwise-operations-to-make-strings-equal/description/
 */
class _2546_执行逐位运算使字符串相等 {

  class Solution {

    /*
     * 真值表
     * 原值  11 10 01 00
     * OR   1  1  1  0
     * XOR  0  1  1  0
     * 由真值表可得当全是0时, 陷入自循环没法转换, 所以只要有1就能互相转换
     * */
    public boolean makeStringsEqual(String s, String target) {
      return s.contains("1") == target.contains("1");
    }
  }
}
