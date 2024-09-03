package com.hyperboat.题单.面试经典150题.栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class _155最小栈 {

  class MinStack {

    int min = Integer.MAX_VALUE;
    Deque<Integer> stack;

    public MinStack() {
      stack = new ArrayDeque<>();
    }

    public void push(int val) {
      if (val < min) {
        stack.offerFirst(min);
        min = val;
      }
      stack.offerFirst(val);
    }

    public void pop() {
      if (stack.pollFirst()==min){
        min = stack.pollFirst();
      }
    }

    public int top() {
      return stack.peekFirst();
    }

    public int getMin() {
      return min;
    }
  }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
