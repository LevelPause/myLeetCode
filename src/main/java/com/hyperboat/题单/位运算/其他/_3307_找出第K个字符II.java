package com.hyperboat.题单.位运算.其他;

/**
 * https://leetcode.cn/problems/find-the-k-th-character-in-string-game-ii/description/
 */
public class _3307_找出第K个字符II {

  class Solution {

    public char kthCharacter(long k, int[] operations) {
      int shift = 0;
      while (k > 1) {
        long maxLen = 1;
        int cnt = 0;
        while ((maxLen << 1) < k) {
          maxLen <<= 1;
          cnt += 1;
        }
        k -= maxLen;
        shift += operations[cnt];
      }
      return (char) ('a' + shift % 26);
    }
  }
}
