package com.hyperboat.题单.程序员面试金典.栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.cn/problems/implement-queue-using-stacks-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * */
class _03_04化栈为队 {

  Deque<Integer> stack1;
  Deque<Integer> stack2;

  /**
   * Initialize your data structure here.
   */
  public _03_04化栈为队() {
    stack1 = new ArrayDeque<>();
    stack2 = new ArrayDeque<>();
  }

  /**
   * Push element x to the back of queue.
   */
  public void push(int x) {
    stack1.push(x);
  }

  /**
   * Removes the element from in front of queue and returns that element.
   */
  public int pop() {
    if (stack2.isEmpty()) {
      in2out();
    }
    return stack2.pop();
  }

  /**
   * Get the front element.
   */
  public int peek() {
    if (stack2.isEmpty()) {
      in2out();
    }
    return stack2.peek();
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }

  public void in2out() {
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
  }
}
