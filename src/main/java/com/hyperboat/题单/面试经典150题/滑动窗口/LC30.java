package com.hyperboat.题单.面试经典150题.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LC30 {

  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> res = new ArrayList<>();
    int wordLen = words[0].length();
    int wordsNum = words.length;
    if (s.length() < words.length * wordLen) {
      return res;
    }
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    for (int i = 0; i < wordLen; i++) {
      int l = i;
      int r = l;
      int hit = 0;
      Map<String, Integer> tempMap = new HashMap<>();
      while (r + wordLen <= s.length()) {
        String tempStr = s.substring(r, r + wordLen);
        r += wordLen;
        // 取出的单词命中了map
        if (map.containsKey(tempStr)) {
          int num = tempMap.getOrDefault(tempStr, 0) + 1;
          tempMap.put(tempStr, num);
          hit++;
          // 1. 命中但单词数量超过了map, 窗口后移至数量符合的位置
          if (num > map.get(tempStr)) {
            while (map.get(tempStr) < tempMap.get(tempStr)) {
              String delStr = s.substring(l, l + wordLen);
              tempMap.put(delStr, tempMap.get(delStr) - 1);
              l += wordLen;
              hit--;
            }
          }
        }
        // 2. 没命中map, 将窗口后移至未命中单词的下一个位置, 重新匹配
        else {
          tempMap.clear();
          hit = 0;
          l = r;
        }
        // 3. 字串完全匹配, 将窗口后移一个单词长度, 继续匹配
        if (hit == wordsNum) {
          res.add(l);
          String firstStr = s.substring(l, l + wordLen);
          tempMap.put(firstStr, tempMap.get(firstStr) - 1);
          hit--;
          l += wordLen;
        }
      }
    }
    return res;
  }
}
