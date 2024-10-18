package com.hyperboat.daily.y2024.m08.d01;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/uOAnQW/description/
 * */
public class LCP40 {

  public int maxmiumScore(int[] cards, int cnt) {
    Arrays.sort(cards);
    int n = cards.length;
    int minOdd = 0;
    int minEven = 0;
    int ans = 0;
    int index = n - 1;
    while (index >= 0) {
      if (cnt-- == 0) {
        break;
      }
      if ((cards[index] & 1) == 1) {
        minOdd = cards[index];
      } else {
        minEven = cards[index];
      }
      ans += cards[index];
      index--;
    }
    if ((ans & 1) == 0) {
      return ans;
    }

    int maxOdd = 0;
    int maxEven = 0;

    for (int i = index; i >= 0 && (maxEven == 0 || maxOdd == 0); i--) {
      if (minOdd != 0 && maxEven == 0 && ((cards[i] & 1) == 0)) {
        maxEven = ans + cards[i] - minOdd;
      }
      if (minEven != 0 && maxOdd == 0 && ((cards[i] & 1) == 1)) {
        maxOdd = ans + cards[i] - minEven;
      }
    }
    return Math.max(maxOdd, maxEven);
  }
}
