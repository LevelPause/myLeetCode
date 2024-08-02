package com.hyperboat.面试经典150题.位运算;

/*
 * https://leetcode.cn/problems/add-binary/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _67二进制求和 {

  public String addBinary(String a, String b) {
    int m = a.length();
    int n = b.length();
    if (m > n) {
      return addBinary(b, a);
    }
    int carry = 0;
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < n; i++) {
      carry += i < m ? a.charAt(m - i - 1) - '0' : 0;
      carry += b.charAt(n - i - 1) - '0';
      sb.append(carry % 2);
      carry /= 2;
    }
    if (carry > 0) {
      sb.append("1");
    }
    return sb.reverse().toString();
  }
}
