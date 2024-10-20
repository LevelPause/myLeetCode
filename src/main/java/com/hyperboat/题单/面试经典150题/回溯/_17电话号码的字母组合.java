package com.hyperboat.题单.面试经典150题.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-interview-150
 * */
class _17电话号码的字母组合 {

  List<String> res;

  Map<Character, char[]> map;

  public List<String> letterCombinations(String digits) {
    res = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return res;
    }
    map = new HashMap<>();
    map.put('2', new char[]{'a', 'b', 'c'});
    map.put('3', new char[]{'d', 'e', 'f'});
    map.put('4', new char[]{'g', 'h', 'i'});
    map.put('5', new char[]{'j', 'k', 'l'});
    map.put('6', new char[]{'m', 'n', 'o'});
    map.put('7', new char[]{'p', 'q', 'r', 's'});
    map.put('8', new char[]{'t', 'u', 'v'});
    map.put('9', new char[]{'w', 'x', 'y', 'z'});
    dfs(0, new StringBuffer(), digits);
    return res;
  }

  public void dfs(int index, StringBuffer sb, String digits) {
    if (index == digits.length()) {
      res.add(sb.toString());
      return;
    }

    for (char c : map.get(digits.charAt(index))) {
      index++;
      sb.append(c);
      dfs(index, sb, digits);
      sb.deleteCharAt(sb.length() - 1);
      index--;
    }

  }
}
