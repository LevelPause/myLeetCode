package com.hyperboat.normal.medium;

import java.util.PriorityQueue;

/**
 * @author zhangweigang
 * @date 2023年10月18日 2:16
 */
public class _2530执行K次操作后的最大分数 {

  public long maxKelements(int[] nums, int k) {
    PriorityQueue<Integer> integers = new PriorityQueue<>((a, b) -> b - a);
    for (int num : nums) {
      integers.offer(num);
    }
    long res = 0L;
    for (int i = 0; i < k; i++) {
      int poll = integers.poll();
      res += poll;
      integers.offer((poll + 2) / 3);
    }
    return res;
  }
}
