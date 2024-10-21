package com.hyperboat.题单.面试经典150题.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LC49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    int[] box = new int[26];
    boolean[] selected = new boolean[strs.length];
    List<List<String>> ans = new ArrayList<>();
    Arrays.sort(strs, Comparator.comparingInt(String::length));

    for (int i = 0; i < strs.length; i++) {
      if (selected[i]) {
        continue;
      }
      List<String> line = new ArrayList<>();
      line.add(strs[i]);
      for (int j = i + 1; j < strs.length; j++) {
        if (strs[i].length() == strs[j].length()) {
          for (int k = 0; k < strs[i].length(); k++) {
            box[strs[i].charAt(k) - 'a']++;
            box[strs[j].charAt(k) - 'a']--;
          }
          boolean connected = true;
          for (int m = 0; m < box.length; m++) {
            if (box[m] != 0) {
              connected = false;
              break;
            }
          }
          if (connected) {
            selected[j] = true;
            line.add(strs[j]);
          }
          box = new int[26];
        } else {
          break;
        }
      }
      ans.add(line);

    }
    return ans;
  }
// 利用map排序 优化写法
  public List<List<String>> groupAnagrams2(String[] strs) {
    Map<String,List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      List<String> line = map.getOrDefault(key, new ArrayList<>());
      line.add(str);
      map.put(key,line);
    }
    return new ArrayList<>(map.values());
  }

}
