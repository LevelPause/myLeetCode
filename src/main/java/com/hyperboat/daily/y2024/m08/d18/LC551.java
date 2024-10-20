package com.hyperboat.daily.y2024.m08.d18;

class LC551 {

  static class Solution {

    public boolean checkRecord(String s) {
      int cntC = 0;
      int index = 0;
      int n = s.length();
      while (index < n) {
        char c = s.charAt(index);
        if (c == 'A') {
          if (++cntC == 2) {
            return false;
          }
          index++;
        } else if (c == 'L') {
          int cnt = 1;
          while (++index < n && s.charAt(index) == 'L') {
            if (++cnt >= 3) {
              return false;
            }
          }
        } else {
          index++;
        }
      }
      return true;
    }
  }

}
