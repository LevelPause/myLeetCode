package com.hyperboat.daily.y2024.m10.d08;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.cn/problems/destination-city/description/?envType=daily-question&envId=2024-10-08
 * */
public class _1436_旅行终点站 {

  class Solution {

    public String destCity(List<List<String>> paths) {
      Set<String> set = new HashSet<>();
      for (List<String> path : paths) {
        set.add(path.get(1));
      }
      for (List<String> path : paths) {
        set.remove(path.get(0));
      }
      return set.iterator().next();
    }
  }
}
