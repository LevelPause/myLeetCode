package com.hyperboat.面试经典150题.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
public class LC3无重复字符的最长子串 {

  //经典滑动窗口, 注意l指针移动时可能会倒转至l左边, 要用取最大值来过滤掉这一情况
  public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    if (n < 2) {
      return n;
    }
    int res = 1;
    int l = 0;
    int r = 0;
    Map<Character, Integer> chars = new HashMap<>();
    while (r < n) {
      if (chars.containsKey(s.charAt(r))) {
        l = Math.max(chars.get(s.charAt(r)) + 1, l);
      }
      res = Math.max(res, r - l + 1);
      chars.put(s.charAt(r), r);
      r++;
    }
    return res;
  }
}
