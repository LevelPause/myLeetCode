package com.hyperboat.题单.dp._1入门dp._1_3最大子数组和;

import java.util.Arrays;

public class _2606_找到最大开销的子字符串 {

  class Solution {

    public int maximumCostSubstring(String s, String chars, int[] vals) {
      int[] b = new int[26];
      Arrays.fill(b, -1);
      for (int i = 0; i < chars.toCharArray().length; i++) {
        char c = chars.charAt(i);
        b[c - 'a'] = i;
      }
      int pre = 0;
      int ans = 0;
      char[] charArray = s.toCharArray();
      for (int i = 0; i < charArray.length; i++) {
        char c = charArray[i];
        int value = b[c - 'a'] > -1 ? vals[b[c - 'a']] : c - 'a' + 1;
        pre = Math.max(pre, 0) + value;
        ans = Math.max(ans, pre);
      }
      return ans;
    }
  }
}
