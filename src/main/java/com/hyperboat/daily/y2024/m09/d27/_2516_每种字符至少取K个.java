package com.hyperboat.daily.y2024.m09.d27;

/*
 * https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/description/
 * */
public class _2516_每种字符至少取K个 {

  // 正难则反, 正向考虑取字符是在字符串的两端, 不连续状态很多, 反过来想最终结果不取的字符串是连续的
  // 也就是在字符串s中取得一串最大长度的连续子串使得左右两端的子串中包含abc的次数都大于k
  class Solution {

    public int takeCharacters(String s, int k) {
      char[] arr = s.toCharArray();
      int n = arr.length;
      //长度不够取足够字母
      if (n < k * 3) {
        return -1;
      }
      // 先将所有字母都取
      int[] cnt = new int[3];
      for (char c : arr) {
        cnt[c - 'a']++;
      }
      //有字母没取满k
      if (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
        return -1;
      }
      //中间的不选的连续子串最大长度
      int max = 0;
      int l = 0;
      //滑动窗口, 不断扩展窗口右边界, 将arr[r]由取转换为不取, 当有字母取的数量小于k时, 缩短左边界, 维护滑窗的最大有效长度
      for (int r = 0; r < n; r++) {
        int i = arr[r] - 'a';
        cnt[i]--;
        while (cnt[i] < k) {
          cnt[arr[l] - 'a']++;
          l++;
        }
        max = Math.max(max, r - l + 1);
      }
      return n - max;
    }
  }
}
