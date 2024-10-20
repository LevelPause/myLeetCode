package com.hyperboat.题单.位运算.其他;

/**
 * 190. 颠倒二进制位
 * <p>
 * https://leetcode.cn/problems/reverse-bits/description/
 */
class LC190 {

  private static final int M1 = 0x55555555;// 0b01010101010101010101010101010101
  private static final int M2 = 0x33333333;// 0b00110011001100110011001100110011
  private static final int M4 = 0x0f0f0f0f;// 0b00001111000011110000111100001111
  private static final int M8 = 0x00ff00ff;//  0b00000000111111110000000011111111

  public int reverseBits(int n) {
    n = n >>> 1 & M1 | (n & M1) << 1;
    n = n >>> 2 & M2 | (n & M2) << 2;
    n = n >>> 4 & M4 | (n & M4) << 4;
    n = n >>> 8 & M8 | (n & M8) << 8;
    return n >>> 16 | n << 16;
  }

}
