package com.hyperboat.面试经典150题.堆;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://leetcode.cn/problems/ipo/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _502IPO {

  //利用最大堆的贪心算法
  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int n = profits.length;
    List<int[]> capitalList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      capitalList.add(new int[]{capital[i], profits[i]});
    }
    capitalList.sort(Comparator.comparingInt(o -> o[0]));
    PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int i = 0;
    while (k-- > 0) {
      while (i < n && capitalList.get(i)[0] <= w) {
        q.add(capitalList.get(i++)[1]);
      }
      if (q.isEmpty()) {
        break;
      }
      w += q.poll();
    }
    return w;
  }
}
