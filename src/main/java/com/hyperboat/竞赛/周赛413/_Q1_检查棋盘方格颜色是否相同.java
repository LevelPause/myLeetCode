package com.hyperboat.竞赛.周赛413;

/*
 * https://leetcode.cn/contest/weekly-contest-413/problems/check-if-two-chessboard-squares-have-the-same-color/description/
 * */
class _Q1_检查棋盘方格颜色是否相同 {

  class Solution {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
      int x1 = coordinate1.charAt(0) - 'a';
      int y1 = coordinate1.charAt(1) - '0';
      int x2 = coordinate2.charAt(0) - 'a';
      int y2 = coordinate2.charAt(1) - '0';
      if (x1 % 2 == x2 % 2) {
        return y1 % 2 == y2 % 2;
      } else {
        return y1 % 2 != y2 % 2;
      }
    }
  }
}
