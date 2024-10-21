package com.hyperboat.题单.程序员面试金典.数组与字符串;

/**
 * 面试题 01.01.判定字符是否唯一
 * https://leetcode.cn/problems/is-unique-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * */
class LCI0101 {

  public boolean isUnique(String astr) {
    int[] bucket = new int[26];
    int mask = 0;
    for (char c : astr.toCharArray()) {
      if ((mask & (1 << (c - 'a'))) != 0) {
        return false;
      } else {
        mask |= 1 << (c - 'a');
      }
    }
    return true;
  }
}
