package com.hyperboat.题单.程序员面试金典.数组与字符串;

/**
 * 面试题 01.04.回文排列
 * <p>
 * https://leetcode.cn/problems/palindrome-permutation-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
class LCI0104 {

  public boolean canPermutePalindrome(String s) {
    int[] b = new int[128];
    for (char c : s.toCharArray()) {
      if (b[c] != 0) {
        b[c]--;
      } else {
        b[c]++;
      }
    }
    int ans = 0;
    for (int i : b) {
      ans += i;
    }
    return ans <= 1;
  }
}
