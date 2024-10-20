package com.hyperboat.题单.面试经典150题.图的广度优先搜索;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.cn/problems/minimum-genetic-mutation/?envType=study-plan-v2&envId=top-interview-150
 * */
class _433最小基因变化 {

  public int minMutation(String startGene, String endGene, String[] bank) {
    int n = endGene.length();
    List<String> bankList = Arrays.asList(bank);
    Map<String, Integer> map = new HashMap<>();
    ArrayDeque<char[]> dq = new ArrayDeque<>();
    dq.offerLast(startGene.toCharArray());
    map.put(startGene, 0);
    char[] words = new char[]{'A', 'C', 'G', 'T'};
    while (!dq.isEmpty()) {
      char[] poll = dq.pollFirst();
      int step = map.get(new String(poll));
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < 4; j++) {
          char newChar = words[j];
          if (poll[i] == newChar) {
            continue;
          }
          char[] clone = poll.clone();
          clone[i] = newChar;
          String newStr = new String(clone);
          if (!bankList.contains(newStr)) {
            continue;
          }
          if (map.containsKey(newStr)) {
            continue;
          }
          if (newStr.equals(endGene)) {
            return step + 1;
          }
          map.put(newStr, step + 1);
          dq.offerLast(clone);
        }
      }
    }
    return -1;
  }
}
