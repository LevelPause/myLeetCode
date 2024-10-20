package com.hyperboat.竞赛.周赛419;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * https://leetcode.cn/contest/weekly-contest-419/problems/find-x-sum-of-all-k-long-subarrays-i/description/
 * */
class _Q1_计算子数组的x_sum_I {

  class Solution {

    public int[] findXSum(int[] nums, int k, int x) {
      int n = nums.length;
      int[] ans = new int[n - k + 1];
      Map<Integer, Integer> cnt = new HashMap<>();
      int len = 0;
      for (int i = 0; i < n; i++) {
        final int num = nums[i];
        cnt.merge(num, 1, Integer::sum);
        len++;
        if (len > k) {
          cnt.merge(nums[i - (k + 1)], -1, Integer::sum);
        }
        if (i >= k - 1) {
          ans[i - (k - 1)] = sum(cnt.entrySet(), x);
        }
      }
      return ans;
    }

    private int sum(Set<Entry<Integer, Integer>> set, int x) {
      List<Entry<Integer, Integer>> list = new ArrayList<>(set);
      list.sort((o1, o2) -> o2.getValue().equals(o1.getValue()) ? o2.getKey() - o1.getKey()
          : o2.getValue() - o1.getValue());
      System.out.println(list);
      int sum = 0;
      for (int i = 0; i < x && i < list.size(); i++) {
        Entry<Integer, Integer> en = list.get(i);
        sum += en.getKey() * en.getValue();
      }
      return sum;
    }
  }
}
