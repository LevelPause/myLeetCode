package com.hyperboat.题单.面试经典150题.数学;

/*
 * https://leetcode.cn/problems/palindrome-number/description/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _9回文数 {

  public boolean isPalindrome(int x) {
    if (x < 0 || x % 10 == 0 && x != 0) {
      return false;
    }
    int reverseNum = 0;
    while (x > reverseNum) {
      reverseNum = reverseNum * 10 + x % 10;
      x /= 10;
    }
    return x == reverseNum || x == reverseNum / 10;
  }
}
