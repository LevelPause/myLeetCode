package com.hyperboat.竞赛.周赛420;

/**
 * Q2. 字符至少出现 K 次的子字符串 I
 * <p>
 * https://leetcode.cn/contest/weekly-contest-420/problems/count-substrings-with-k-frequency-characters-i/description/
 */
class Q2 {

  public int numberOfSubstrings(String s, int k) {
    var ans = 0;
    var n = s.length();
    var l = 0;
    var cnt = new int[26];
    var cntK = 0;
    for (int r = 0; r < n; r++) {
      char c = s.charAt(r);
      if (++cnt[c - 'a'] == k) {
        cntK++;
      }
      while (cntK > 0 && l < n) {
        // System.out.println(Arrays.toString(cnt));
        int x = s.charAt(l) - 'a';
        cnt[x]--;
        if (cnt[x] == k - 1) {
          cntK--;
        }
        // System.out.println(l+"=="+ans);
        // System.out.println(x);
        l++;
      }
      ans += l;
    }
    return ans;
  }
}
