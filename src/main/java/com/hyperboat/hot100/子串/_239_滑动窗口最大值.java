package com.hyperboat.hot100.子串;

import java.util.PriorityQueue;

/*
 * https://leetcode.cn/problems/sliding-window-maximum/?envType=study-plan-v2&envId=top-100-liked
 * */
public class _239_滑动窗口最大值 {

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    int i = 0;
    int[] ans = new int[n - k + 1];
    while (i < k) {
      p.offer(new int[]{nums[i], i});
      i++;
    }
    ans[0] = p.peek()[0];

    while (i < n) {
      p.offer(new int[]{nums[i], i});
//      延迟删除
      while (p.peek()[1] <= i - k) {
        p.poll();
      }
      ans[i - k + 1] = p.peek()[0];
      i++;
    }

    return ans;
  }
}
