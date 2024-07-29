package com.hyperboat.面试经典150题.哈希表;

import java.util.HashMap;

public class _205同构字符串 {

  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Character> s2t = new HashMap<>();
    HashMap<Character, Character> t2s = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      if ((s2t.containsKey(sChar) && s2t.get(sChar) != tChar)
          || t2s.containsKey(tChar) && t2s.get(tChar) != sChar) {
        return false;
      }
      s2t.put(sChar, tChar);
      t2s.put(tChar, sChar);
    }
    return true;
  }
}
