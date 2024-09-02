package com.hyperboat.竞赛.双周赛138;

public class _Q2_哈希分割字符串 {

  class Solution {

    public String stringHash(String s, int k) {
      int n = s.length();
      int index = 0;
      int count = 0;
      int sum = 0;
      StringBuilder sb = new StringBuilder();
      while (index < n) {
        if (count < k) {
          count++;
          sum += (int) s.charAt(index) - 'a';
          index++;
         if (count==k){
           sb.append((char) (sum % 26 + 'a'));
           sum = 0;
           count = 0;
         }
        }
      }
      return sb.toString();
    }
  }
}
