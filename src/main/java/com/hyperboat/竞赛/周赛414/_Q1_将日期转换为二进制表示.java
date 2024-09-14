package com.hyperboat.竞赛.周赛414;

public class _Q1_将日期转换为二进制表示 {

  class Solution {

    public String convertDateToBinary(String date) {
      int year = Integer.parseInt(date.substring(0, 4));
      int month = Integer.parseInt(date.substring(5, 7));
      int day = Integer.parseInt(date.substring(8, 10));
      return Integer.toBinaryString(year) + "-" + Integer.toBinaryString(month) + "-"
          + Integer.toBinaryString(day);
    }
  }
}
