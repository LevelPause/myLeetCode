package com.hyperboat.daily.y2024.m7.d24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * https://leetcode.cn/problems/relocate-marbles/description/
 * */
public class _2766重新放置石块 {

  public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
    return hashset(nums, moveFrom, moveTo);
  }

  /*
   * 第一种hashmap存储，移动时删除即可，第一时间没读对题，跟数量没关系，用set更好
   *
   * */
  public List<Integer> hashmap(int[] nums, int[] moveFrom, int[] moveTo) {
    Map<Integer, Integer> index2count = new HashMap<>();
    for (int num : nums) {
      index2count.put(num, index2count.getOrDefault(num, 0) + 1);
    }
    int n = moveFrom.length;
    for (int i = 0; i < n; i++) {
      int newFrom = index2count.get(moveFrom[i]);
      index2count.remove(moveFrom[i]);
      index2count.put(moveTo[i], index2count.getOrDefault(moveTo[i], 0) + newFrom);
    }
    return index2count.keySet().stream().sorted().collect(Collectors.toList());
  }

  /*
   * 第二种方法
   *  hashset 去重
   * */
  public List<Integer> hashset(int[] nums, int[] moveFrom, int[] moveTo) {
    Set<Integer> index = new HashSet<>();
    for (int num : nums) {
      index.add(num);
    }
    int n = moveFrom.length;
    for (int i = 0; i < n; i++) {
      index.remove(moveFrom[i]);
      index.add(moveTo[i]);
    }
    return index.stream().sorted().collect(Collectors.toList());
  }
}
