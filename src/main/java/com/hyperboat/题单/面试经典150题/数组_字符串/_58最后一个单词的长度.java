package com.hyperboat.题单.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月22日
 */
public class _58最后一个单词的长度 {

  //简单简单 注意尾部会有空格 不要忘了判断就行
  public int lengthOfLastWord(String s) {
    int end = s.length() - 1;
    int start = s.length() - 1;
    int res = 0;
    for (int i = end; i >= 0; i--) {
      if (s.charAt(i) == ' ') {
        if (start == end) {
          start++;
          end++;
        } else {
          return res;
        }
      } else {
        res++;
        start++;
      }
    }
    return res;
  }
}
