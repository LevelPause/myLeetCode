package com.hyperboat.题单.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
public class _151反转字符串中的单词 {

  public String reverseMessage(String message) {
    StringBuilder res = new StringBuilder();
    int n = message.length();
    if (n < 1) {
      return message;
    }
    int start = n - 1;
    int end = n - 1;
    for (int i = n - 1; i >= 0; i--) {
      if (start == end && message.charAt(i) == ' ') {
        start--;
        end--;
      }
      if (start != end && message.charAt(i) == ' ') {
        res.append(message, start + 1, end + 1).append(' ');
        start--;
        end = start;
      }
      if (message.charAt(i) != ' ') {
        start--;
        if (i == 0) {
          res.append(message, start + 1, end + 1);
        }
      }
    }
    if (res.length() > 1 && res.charAt(res.length() - 1) == ' ') {
      res.deleteCharAt(res.length() - 1);
    }
    return res.toString();
  }
}
