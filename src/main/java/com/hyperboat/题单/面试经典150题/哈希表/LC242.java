package com.hyperboat.题单.面试经典150题.哈希表;

class LC242 {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] box = new int[26];
    for (int i = 0; i < s.length(); i++) {
      box[s.charAt(i) - 'a']++;
      box[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < box.length; i++) {
      if (box[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
