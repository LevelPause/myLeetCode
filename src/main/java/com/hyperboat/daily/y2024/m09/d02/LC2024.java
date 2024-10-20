package com.hyperboat.daily.y2024.m09.d02;

class LC2024 {

  class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
      return Math.max(getCnt('T', answerKey, k), getCnt('F', answerKey, k));
    }

    private int getCnt(char c, String s, int k) {
      int n = s.length();
      int l = 0, r = 0;
      int cntC = 0;
      int len = 0;
      while (r < n) {
        if (s.charAt(r) == c) {
          cntC++;
        }
        while (l < r && cntC > k) {
          if (s.charAt(l++) == c) {
            cntC--;
            break;
          }
        }
        len = Math.max(len, r - l + 1);
        r++;
      }
      return len;
    }
  }
}
