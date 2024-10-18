package com.hyperboat.daily.y2024.m09.d11;

/*
 * https://leetcode.cn/problems/maximize-win-from-two-segments/description/
 * */
public class LC2555 {

  class Solution {

    public int maximizeWin(int[] prizePositions, int k) {
      int n = prizePositions.length;
      if (k * 2 + 1 >= prizePositions[n - 1] - prizePositions[0]) {
        return n;
      }
      int ans = 0;
      int left = 0;
      int[] mx = new int[n + 1];
      for (int right = 0; right < n; right++) {
        while (prizePositions[right] - prizePositions[left] > k) {
          left++;
        }
        ans = Math.max(ans, mx[left] + right - left + 1);
        mx[right + 1] = Math.max(mx[right], right - left + 1);
      }
      return ans;
    }
  }
}
