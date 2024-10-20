package com.hyperboat.竞赛.周赛419;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
 * https://leetcode.cn/contest/weekly-contest-419/problems/find-x-sum-of-all-k-long-subarrays-i/description/
 * */
class _Q4_计算子数组的x_sum_II {


  class Solution {

    private Map<Integer, Integer> cnt;
    private TreeSet<Long> rest;
    private TreeSet<Long> topX;
    private long sum;

    public long[] findXSum(int[] nums, int k, int x) {
      int n = nums.length;
      // 小顶堆
      topX = new TreeSet<>();
      // 大顶堆
      rest = new TreeSet<>();
      cnt = new HashMap<>();
      long[] ans = new long[n - k + 1];
      for (int r = 0; r < n; r++) {
        int in = nums[r];
        remove(in);
        cnt.merge(in, 1, Integer::sum);
        add(in);
        int l = r - k + 1;
        if (l < 0) {
          continue;
        }
        while (!rest.isEmpty() && topX.size() < x) {
          long last = rest.pollLast();
          topX.add(last);
          sum += (last >> 32) * (int) last;
        }
        while (topX.size() > x) {
          long first = topX.pollFirst();
          rest.add(first);
          sum -= (first >> 32) * (int) first;
        }
        ans[l] = sum;
        int out = nums[l];
        remove(out);
        cnt.merge(out, -1, Integer::sum);
        add(out);
      }
      return ans;
    }

    private void add(int x) {
      int count = cnt.get(x);
      if (count == 0) {
        return;
      }
      long newX = (long) count << 32 | x;
      if (!topX.isEmpty() && Long.compare(newX, topX.first()) > 0) {
        topX.add(newX);
        sum += (newX >> 32) * (int) newX;
      } else {
        rest.add(newX);
      }
    }

    private void remove(int x) {
      int count = cnt.getOrDefault(x, 0);
      if (count == 0) {
        return;
      }
      long newX = (long) count << 32 | x;
      if (rest.contains(newX)) {
        rest.remove(newX);
      } else {
        topX.remove(newX);
        sum -= (newX >> 32) * (int) newX;
      }
    }
  }

}
