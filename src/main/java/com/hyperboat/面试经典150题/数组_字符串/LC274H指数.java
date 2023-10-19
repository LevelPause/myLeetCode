package com.hyperboat.面试经典150题.数组_字符串;

import java.util.Arrays;

/**
 * @author zhangweigang
 * @date 2023年10月20日 3:59
 */
public class LC274H指数 {

  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int res = 0;
    for (int i = citations.length - 1; i >= 0; i--) {
      if (citations[i] > res) {
        res++;
      } else {
        break;
      }
    }
    return res;
  }
}
