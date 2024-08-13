package com.hyperboat.程序员面试金典.栈与队列;

import java.util.LinkedList;

/*
 * https://leetcode.cn/problems/animal-shelter-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * */
public class _03_06动物收容所 {

  LinkedList<int[]> stack;

  public _03_06动物收容所() {
    stack = new LinkedList<>();
  }

  public void enqueue(int[] animal) {
    stack.addFirst(animal);
  }

  public int[] dequeueAny() {
    if (stack.isEmpty()) {
      return new int[]{-1, -1};
    } else {
      return stack.pollLast();
    }
  }

  public int[] dequeueDog() {
    for (int[] animal : stack) {
      if (animal[1] == 1) {
        stack.remove(animal);
        return animal;
      }
    }
    return new int[]{-1, -1};
  }

  public int[] dequeueCat() {
    for (int[] animal : stack) {
      if (animal[1] == 0) {
        stack.remove(animal);
        return animal;
      }
    }
    return new int[]{-1, -1};
  }
}
