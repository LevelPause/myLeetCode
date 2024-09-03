package com.hyperboat.题单.hot100.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_电话号码的字母组合 {

  class Solution {

    Map<Character, List<Character>> map = new HashMap<>();
    private List<String> res;

    {
      map.put('2', Arrays.asList('a', 'b', 'c'));
      map.put('3', Arrays.asList('d', 'e', 'f'));
      map.put('4', Arrays.asList('g', 'h', 'i'));
      map.put('5', Arrays.asList('j', 'k', 'l'));
      map.put('6', Arrays.asList('m', 'n', 'o'));
      map.put('7', Arrays.asList('p', 'q', 'r', 's'));
      map.put('8', Arrays.asList('t', 'u', 'v'));
      map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
      res = new ArrayList<>();
      if (digits==null||digits.length()==0){
        return res;
      }
      backTrace(0, digits, new StringBuilder());
      return res;
    }

    private void backTrace(int index, String digits, StringBuilder line) {
      int n = digits.length();
      if (index == n) {
        res.add(line.toString());
        return;
      }
      char c = digits.charAt(index);
      for (Character item : map.get(c)) {
        line.append(item);
        backTrace(index + 1, digits, line);
        line.deleteCharAt(line.length() - 1);
      }
    }
  }
}
