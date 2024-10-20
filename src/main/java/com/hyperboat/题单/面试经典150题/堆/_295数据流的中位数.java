package com.hyperboat.题单.面试经典150题.堆;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.cn/problems/find-median-from-data-stream/?envType=study-plan-v2&envId=top-interview-150
 * */
class _295数据流的中位数 {

  PriorityQueue<Integer> qt;
  PriorityQueue<Integer> lt;

  public _295数据流的中位数() {
    qt = new PriorityQueue<>((a, b) -> b - a);
    lt = new PriorityQueue<>(Comparator.comparingInt(a -> a));
  }

  public void addNum(int num) {
    if (qt.size() == lt.size()) {
      if (lt.isEmpty() || num <= lt.peek()) {
        qt.add(num);
      } else {
        qt.add(lt.poll());
        lt.add(num);
      }
    } else {
      if (num < qt.peek()) {
        lt.add(qt.poll());
        qt.add(num);
      } else {
        lt.add(num);
      }
    }
  }

  public double findMedian() {
    int size = qt.size() + lt.size();
    return (size & 1) == 1 ? qt.peek() : (qt.peek() + lt.peek()) / 2.0d;
  }
}
