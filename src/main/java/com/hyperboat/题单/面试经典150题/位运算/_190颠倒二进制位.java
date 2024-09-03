package com.hyperboat.题单.面试经典150题.位运算;

/*
 *
 * https://leetcode.cn/problems/reverse-bits/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _190颠倒二进制位 {

  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int total = 32;
    int res = 0;
    while (total-- > 0) {
      if (n == 0) {
        break;
      }
      res += (n & 1) == 1 ? 1 << total : 0;
      System.out.println(Integer.toBinaryString(res));
      n >>= 1;
    }
    return res;
  }

  private static final int M1 = 0x55555555;
  private static final int M2 = 0x33333333;
  private static final int M4 = 0x0f0f0f0f;
  private static final int M8 = 0x00ff00ff;

  //分治思想
  public int reverseBitsByMask(int n) {
    n = n >>> 1 | (n & M1) << 1;
    n = n >>> 2 | (n & M2) << 2;
    n = n >>> 4 | (n & M4) << 4;
    n = n >>> 8 | (n & M8) << 8;
    return n >>> 16 | n << 16;
  }
}
