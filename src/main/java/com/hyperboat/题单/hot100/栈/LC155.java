package com.hyperboat.题单.hot100.栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 * <p>
 * https://leetcode.cn/problems/min-stack/description/
 */
class LC155 {

  class MinStack {

    private Deque<Integer> dq;
    private int min;

    public MinStack() {
      dq = new LinkedList<>();
      min = Integer.MAX_VALUE;
    }

    public void push(int val) {
      if (min > val) {
        dq.push(min);
        min = val;
      }
      dq.push(val);
    }

    public void pop() {
      if (dq.pop() == min) {
        min = dq.pop();
      }
    }

    public int top() {
      return dq.peek();
    }

    public int getMin() {
      return min;
    }
  }

}
