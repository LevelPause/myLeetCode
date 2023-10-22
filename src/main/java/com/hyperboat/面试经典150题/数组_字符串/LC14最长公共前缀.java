package com.hyperboat.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
public class LC14最长公共前缀 {

  //简单题!!!
  public String longestCommonPrefix(String[] strs) {
    StringBuilder res = new StringBuilder();
    int minLength = Integer.MAX_VALUE;
    for (String str : strs) {
      minLength = Math.min(str.length(), minLength);
    }
    for (int i = 0; i < minLength; i++) {
      char temp = ' ';
      for (int i1 = 0; i1 < strs.length; i1++) {
        if (i1 == 0) {
          temp = strs[i1].charAt(i);
        }
        if (temp != strs[i1].charAt(i)) {
          return res.toString();
        }
      }
      res.append(temp);
    }
    return res.toString();
  }

}

