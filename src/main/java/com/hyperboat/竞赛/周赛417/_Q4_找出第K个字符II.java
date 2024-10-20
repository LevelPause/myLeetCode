package com.hyperboat.竞赛.周赛417;

/*
 * https://leetcode.cn/contest/weekly-contest-417/problems/find-the-k-th-character-in-string-game-i/description/
 * */
class _Q4_找出第K个字符II {

  class Solution {

    public char kthCharacter(long k, int[] operations) {
      return inOrder(k, operations);
    }

    //顺序
    private char inOrder(long k, int[] operations) {
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

    //逆序
    private char reverseOrder(long k, int[] operations) {
      int n = Math.min(operations.length, 64 - Long.numberOfLeadingZeros(k));
      int cnt = 0;
      for (int i = n - 1; i > 0; i--) {
        if (k > 1L << i) {
          k -= 1L << i;
          cnt += operations[i];
        }
      }
      return (char) ('a' + cnt % 26);
    }
  }
}
