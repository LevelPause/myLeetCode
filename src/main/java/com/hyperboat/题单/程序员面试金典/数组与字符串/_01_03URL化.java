package com.hyperboat.题单.程序员面试金典.数组与字符串;

/*
 * https://leetcode.cn/problems/string-to-url-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * */
public class _01_03URL化 {

  public String replaceSpaces(String S, int length) {
    return chars(S, length);
  }

  public String sb(String S, int length) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < length; i++) {
      if (S.charAt(i) == ' ') {
        sb.append("%20");
      } else {
        sb.append(S.charAt(i));
      }
    }
    return sb.toString();
  }

  public String chars(String S, int length) {
    char[] chars = S.toCharArray();
    int i = chars.length - 1;
    for (int j = length - 1; j >= 0; j--) {
      if (chars[j] == ' ') {
        chars[i--] = '0';
        chars[i--] = '2';
        chars[i--] = '%';
      } else {
        chars[i--] = chars[j];
      }
    }
    return new String(chars, i + 1, chars.length - i - 1);
  }
}
