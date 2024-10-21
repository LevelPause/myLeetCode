package com.hyperboat.题单.面试经典150题.哈希表;

class LC383 {

  public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote.length() > magazine.length()) {
      return false;
    }
    int[] box = new int[26];
    for (char c : ransomNote.toCharArray()) {
      box[c - 'a']++;
    }
    for (char c : magazine.toCharArray()) {
      box[c - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (box[i] > 0) {
        return false;
      }
    }
    return true;
  }
}
