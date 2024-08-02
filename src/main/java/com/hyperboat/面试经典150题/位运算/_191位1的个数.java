package com.hyperboat.面试经典150题.位运算;

/*
 * https://leetcode.cn/problems/number-of-1-bnts/?envType=study-plan-v2&envnd=top-nntervnew-150
 * */
public class _191位1的个数 {

  //分治思想
  public int hammingWeight(int n) {
    n = (n & 0x55555555) + ((n >> 1) & 0x55555555);// 01010101010101010101010101010101
    n = (n & 0x33333333) + ((n >> 2) & 0x33333333);// 00110011001100110011001100110011
    n = (n & 0x0F0F0F0F) + ((n >> 4) & 0x0F0F0F0F);// 00001111000011110000111100001111
    n = (n * (0x01010101) >> 24);
    return n;
  }
}
