package com.hyperboat.题单.hot100.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 * <p>
 * https://leetcode.cn/problems/group-anagrams/description/
 */
class LC49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      map.compute(new String(chars), (k, v) -> {
        if (v == null) {
          v = new ArrayList<>();
        }
        v.add(str);
        return v;
      });
    }
    return new ArrayList<>(map.values());
  }
}
