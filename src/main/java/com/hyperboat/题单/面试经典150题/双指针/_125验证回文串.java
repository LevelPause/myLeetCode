package com.hyperboat.题单.面试经典150题.双指针;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
class _125验证回文串 {

  //简单, 过滤掉不符合题意的字符然后进行头尾判断相等即可, 为节省空间, 可直接在原串遍历, 不符合条件的字符跳过即可, 注意要及时判断循环条件, 防止出现越界
  public boolean isPalindrome(String s) {
    boolean res = true;
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      while (start < end && !isWordOrNum(s.charAt(start))) {
        start++;
      }
      while (start < end && !isWordOrNum(s.charAt(end))) {
        end--;
      }
      if (start >= end) {
        break;
      }
      char startChar =
          isUpperNum(s.charAt(start)) ? (char) (s.charAt(start) | 0x20) : s.charAt(start);
      char endChar =
          isUpperNum(s.charAt(end)) ? (char) (s.charAt(end) | 0x20) : s.charAt(end);
      if (startChar == endChar) {
        start++;
        end--;
      } else {
        return false;
      }
    }
    return res;
  }

  boolean isWordOrNum(char c) {
    return (c >= 97 && c <= 122) //小写字母
        || (c >= 65 && c <= 90) //大写字母
        || (c >= 48 && c <= 57);//数字
  }

  boolean isUpperNum(char c) {
    return (c >= 65 && c <= 90); //大写字母
  }
}
