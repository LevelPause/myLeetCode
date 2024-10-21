package com.hyperboat.题单.面试经典150题.哈希表;

import java.util.HashMap;

class LC290 {

  public boolean wordPattern(String pattern, String s) {
    String[] split = s.split(" ");
    if (pattern.length() != split.length) {
      return false;
    }
    HashMap<Character, String> s2t = new HashMap<>();
    HashMap<String, Character> t2s = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
      char sChar = pattern.charAt(i);
      String str = split[i];
      if ((s2t.containsKey(sChar) && !s2t.get(sChar).equals(str))
          || t2s.containsKey(str) && t2s.get(str) != sChar) {
        return false;
      }
      s2t.put(sChar, str);
      t2s.put(str, sChar);
    }
    return true;
  }
}
