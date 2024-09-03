package com.hyperboat.题单.程序员面试金典.栈与队列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * https://leetcode.cn/problems/stack-of-plates-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * */
public class _03_03堆盘子 {

  List<Deque<Integer>> stacks;
  int cap;

  public _03_03堆盘子(int cap) {
    stacks = new ArrayList<>();
    this.cap = cap;
  }

  public void push(int val) {
    if (cap <= 0) {
      return;
    }
    if (stacks.isEmpty() || cap == stacks.get(stacks.size() - 1).size()) {
      Deque<Integer> line = new ArrayDeque<>();
      line.push(val);
      stacks.add(line);
    } else {
      stacks.get(stacks.size() - 1).push(val);
    }
  }

  public int pop() {
    if (stacks.isEmpty()) {
      return -1;
    }
    int index = stacks.size() - 1;
    Deque<Integer> line = stacks.get(index);
    int val = line.pop();
    if (line.isEmpty()) {
      stacks.remove(index);
    }
    return val;
  }

  public int popAt(int index) {
    int maxIndex = stacks.size() - 1;
    if (stacks.isEmpty() || index < 0 || index > maxIndex) {
      return -1;
    } else {
      Deque<Integer> line = stacks.get(index);
      int val = line.pop();
      if (line.isEmpty()) {
        stacks.remove(index);
      }
      return val;
    }
  }
}
