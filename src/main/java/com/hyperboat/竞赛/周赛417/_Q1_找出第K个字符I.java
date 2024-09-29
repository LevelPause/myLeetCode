package com.hyperboat.竞赛.周赛417;

/*
 * https://leetcode.cn/contest/weekly-contest-417/problems/find-the-k-th-character-in-string-game-i/description/
 * */
public class _Q1_找出第K个字符I {

  class Solution {

    public char kthCharacter(int k) {
      char[] arr = new char[k];
      arr[0] = 'a';
      int index = 1;
      while (index < k) {
        int start = 0;
        int p = index;
        while (index < k && start < p) {
          arr[index++] = (char) (arr[start++] + 1);
        }
      }
      return arr[k - 1];
    }
  }
}
