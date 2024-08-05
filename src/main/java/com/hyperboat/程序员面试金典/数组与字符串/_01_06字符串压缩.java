package com.hyperboat.程序员面试金典.数组与字符串;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/compress-string-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * */
public class _01_06字符串压缩 {

  public String compressString(String S) {
    int n = S.length();
    if (n <= 2) {
      return S;
    }
    Map<Character, Integer> map = new HashMap<>();
    map.put(S.charAt(0), 1);
    StringBuffer sb = new StringBuffer();
    for (int i = 1; i < n; i++) {
      char curr = S.charAt(i);
      char pre = S.charAt(i - 1);
      if (pre != curr) {
        sb.append(pre).append(map.get(pre));
        map.remove(pre);
      }
      map.put(curr, map.getOrDefault(curr, 0) + 1);
    }
    sb.append(S.charAt(n - 1)).append(map.get(S.charAt(n - 1)));
    return sb.length() < n ? sb.toString() : S;
  }
}
