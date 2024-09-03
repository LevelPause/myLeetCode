package com.hyperboat.题单.程序员面试金典.数组与字符串;

/*
 * https://leetcode.cn/problems/string-rotation-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * */
public class _01_09字符串轮转 {

  public boolean isFlipedString(String s1, String s2) {
    return s1.length() == s2.length() && (s1 + s1).contains(s2);
  }
}
