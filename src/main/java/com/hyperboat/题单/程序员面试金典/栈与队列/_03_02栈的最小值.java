package com.hyperboat.题单.程序员面试金典.栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

class _03_02栈的最小值 {

  Deque<Integer> stack;
  int min;

  /**
   * initialize your data structure here.
   */
  public _03_02栈的最小值() {
    stack = new ArrayDeque<>();
    min = Integer.MAX_VALUE;
  }

  public void push(int x) {
    if (x <= min) {
      stack.push(min);
      min = x;
    }
    stack.push(x);
  }

  public void pop() {
    if (stack.pop() == min) {
      min =stack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}
