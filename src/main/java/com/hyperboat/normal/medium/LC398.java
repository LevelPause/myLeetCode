package com.hyperboat.normal.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LC398 {

  class Solution {

    private Map<Integer, List<Integer>> map;
    private Random random;

    public Solution(int[] nums) {
      map = new HashMap<>();
      random = new Random();
      for (int i = 0; i < nums.length; i++) {
        List<Integer> val = map.get(nums[i]);
        if (val == null) {
          val = new ArrayList<>();
        }
        val.add(i);
        map.put(nums[i], val);
      }
    }

    public int pick(int target) {
      if (map.containsKey(target)) {
        List<Integer> val = map.get(target);
        return val.get(random.nextInt(val.size()));
      } else {
        return -1;
      }
    }
  }

  //水塘抽样
  class Solution1 {

    private final int[] nums;
    private Random random;

    public Solution1(int[] nums) {
      random = new Random();
      this.nums = nums;
    }

    public int pick(int target) {
      int ans = 0;
      int cnt = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
          cnt++;
          if (random.nextInt(cnt) == 0) {
            ans = i;
          }
        }
      }
      return ans;
    }
  }
}
