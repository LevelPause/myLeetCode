package com.hyperboat.hot100.堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _295_数据流的中位数 {

  class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
      min = new PriorityQueue<>(Comparator.comparingInt(o -> o));
      max = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
      if (max.isEmpty()) {
        max.offer(num);
      } else {
        if (max.size() == min.size()) {
          if (num > min.peek()) {
            max.offer(min.poll());
            min.offer(num);
          } else {
            max.offer(num);
          }
        } else {
          if (num < max.peek()) {
            min.offer(max.poll());
            max.offer(num);
          } else {
            min.offer(num);
          }
        }
      }
    }

    public double findMedian() {
      if (max.size() > 0) {
        if (min.size() == max.size()) {
          return (min.peek() + max.peek()) / 2.0d;
        } else {
          return max.peek();
        }
      }
      //不可达
      return -100001;
    }
  }

}
