package com.hyperboat.题单.hot100.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
 * */
public class _438_找到字符串中所有字母异位词 {

  public List<Integer> findAnagrams(String s, String p) {
    return normal1(s, p);
  }

  /*滑动窗口+数组判重*/
  public List<Integer> normal1(String s, String p) {
    int m = s.length();
    int n = p.length();
    if (m < n) {
      return new ArrayList<>();
    }
    List<Integer> res = new ArrayList<>();
    int[] pArr = new int[26];
    int[] sArr = new int[26];
    for (int i = 0; i < n; i++) {
      sArr[s.charAt(i) - 'a']++;
      pArr[p.charAt(i) - 'a']++;
    }
    if (Arrays.equals(sArr, pArr)) {
      res.add(0);
    }
    for (int i = 0; i < m - n; i++) {
      sArr[s.charAt(i) - 'a']--;
      sArr[s.charAt(i + n) - 'a']++;
      if (Arrays.equals(sArr, pArr)) {
        res.add(i + 1);
      }
    }
    return res;

  }

  /*滑动窗口+数组判重+双指针*/
  public List<Integer> normal2(String s, String p) {
    int m = s.length();
    int n = p.length();
    if (m < n) {
      return new ArrayList<>();
    }
    List<Integer> res = new ArrayList<>();
    int[] pArr = new int[26];
    int[] sArr = new int[26];
    for (char c : p.toCharArray()) {
      pArr[c - 'a']++;
    }
    int l = 0;
    int r = 0;
    while (r < m) {
      char c = s.charAt(r);
      sArr[c - 'a']++;
      while (sArr[c - 'a'] > pArr[c - 'a']) {
        sArr[s.charAt(l) - 'a']--;
        l++;
      }
      if (r - l + 1 == n) {
        res.add(l);
      }
      r++;
    }
    return res;

  }
}
