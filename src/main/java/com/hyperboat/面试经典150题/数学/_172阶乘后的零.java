package com.hyperboat.面试经典150题.数学;

/*
 * https://leetcode.cn/problems/factorial-trailing-zeroes/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _172阶乘后的零 {

  /*
   * 统计0的个数也就是统计 10 的个数， 10 可以分解为5*2，也就是统计(5,2)数对的个数
   * 根据数学统计，在阶乘中2的出现频率远高于5，所以5的出现次数就相当于10的出现次数
   * 根据统计，每隔5个数出现一次5 ，每隔25个数出现两个5，依次类推
   * 所以 n/5=5出现的次数，n/25是25出现的次数，依此类推
   * */
  public int trailingZeroes(int n) {
    int ans = 0;
    while (n > 0) {
      ans += n / 5;
      n /= 5;
    }
    return ans;
  }
}
