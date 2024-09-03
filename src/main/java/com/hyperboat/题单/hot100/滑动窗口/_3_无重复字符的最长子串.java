package com.hyperboat.题单.hot100.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class _3_无重复字符的最长子串 {

  public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    if (n < 2) {
      return n;
    }
    int l = 0;
    int r = 0;
    int ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    while (r < n) {
      char c = s.charAt(r);
      if (map.containsKey(c)) {
        l = Math.max(map.get(c) + 1, l);
      }
      map.put(c, r);
      ans = Math.max(ans, r - l + 1);
      r++;
    }
    return ans;
  }
}
