package com.hyperboat.题单.程序员面试金典.栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题 03.05.栈排序
 * <p>
 * https://leetcode.cn/problems/sort-of-stacks-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */

class LCI0305 {

  Deque<Integer> stack;
  Deque<Integer> minStack;

  public LCI0305() {
    stack = new ArrayDeque<>();
    minStack = new ArrayDeque<>();
  }

  public void push(int val) {
    while (!stack.isEmpty() && stack.peek() < val) {
      minStack.push(stack.pop());
    }
    stack.push(val);
    while (!minStack.isEmpty()) {
      stack.push(minStack.pop());
    }
  }

  public void pop() {
    if (!stack.isEmpty()) {
      stack.pop();
    }
  }

  public int peek() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.peek();
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }
}
