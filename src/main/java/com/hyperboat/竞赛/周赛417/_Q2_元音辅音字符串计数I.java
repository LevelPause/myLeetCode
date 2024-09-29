package com.hyperboat.竞赛.周赛417;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/contest/weekly-contest-417/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/
 * */
public class _Q2_元音辅音字符串计数I {

  static class Solution {

    private char[] chars;

    public int countOfSubstrings(String word, int k) {
      chars = word.toCharArray();
      return count(k) - count(k + 1);
    }

    private int count(int k) {
      int n = chars.length;
      int l = 0, cntC = 0, ans = 0;
      Map<Character, Integer> cnt = new HashMap<>();
      for (int r = 0; r < n; r++) {

        if (isVowel(chars[r])) {
          cnt.merge(chars[r], 1, Integer::sum);
        } else {
          cntC++;
        }
        while (cnt.size() == 5 && cntC >= k) {
          if (isVowel(chars[l])) {
            Integer x = cnt.get(chars[l]);
            if (x == 1) {
              cnt.remove(chars[l]);
            } else {
              cnt.put(chars[l], x - 1);
            }
          } else {
            cntC--;
          }
          l++;
        }
        ans += l;
      }
      return ans;
    }

    private boolean isVowel(char c) {
      return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
  }

  public static void main(String[] args) {
    System.out.println(1);
  }
}
