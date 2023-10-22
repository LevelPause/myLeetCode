package com.hyperboat.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
public class LC13罗马数字转整数 {

  //简单题 题目怎么说就怎么做就是
  public int romanToInt(String s) {
    int n = s.length();
    int res = 0;
    for (int i = 0; i < n; i++) {
      switch (s.charAt(i)) {
        case 'I':
          if (i + 1 < n && s.charAt(i + 1) == 'V') {
            res += 4;
            i++;
            break;
          }
          if (i + 1 < n && s.charAt(i + 1) == 'X') {
            res += 9;
            i++;
            break;
          }
          res += 1;
          break;
        case 'V':
          res += 5;
          break;
        case 'X':
          if (i + 1 < n && s.charAt(i + 1) == 'L') {
            res += 40;
            i++;
            break;
          }
          if (i + 1 < n && s.charAt(i + 1) == 'C') {
            res += 90;
            i++;
            break;
          }
          res += 10;
          break;
        case 'L':
          res += 50;
          break;
        case 'C':
          if (i + 1 < n && s.charAt(i + 1) == 'D') {
            res += 400;
            i++;
            break;
          }
          if (i + 1 < n && s.charAt(i + 1) == 'M') {
            res += 900;
            i++;
            break;
          }
          res += 100;
          break;
        case 'D':
          res += 500;
          break;
        case 'M':
          res += 1000;
          break;
      }
    }
    return res;
  }
}
