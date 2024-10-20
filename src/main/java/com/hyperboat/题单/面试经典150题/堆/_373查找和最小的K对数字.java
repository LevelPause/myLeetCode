package com.hyperboat.题单.面试经典150题.堆;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/?envType=study-plan-v2&envId=top-interview-150
 * */
class _373查找和最小的K对数字 {

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    int m = nums1.length;
    int n = nums2.length;
    PriorityQueue<List<Integer>> q = new PriorityQueue<>(
        (a, b) -> (b.get(0) + b.get(1)) - (a.get(0) + a.get(1)));
    boolean end = false;
    for (int i = 0; i < m && !end; i++) {
      for (int j = 0; j < n; j++) {
        int sum = nums1[i] + nums2[j];
        if (k-- > 0) {
          q.add(Arrays.asList(nums1[i], nums2[j]));
        } else {
          List<Integer> peek = q.peek();
          int pickSum = peek.get(0) + peek.get(1);
          if (sum < pickSum) {
            q.poll();
            q.add(Arrays.asList(nums1[i], nums2[j]));
          } else {
            if (j == 0) {
              end = true;
            }
            break;
          }
        }
      }
    }
    return new ArrayList<>(q);
  }
}
