package com.hyperboat.题单.程序员面试金典.栈与队列;

import java.util.LinkedList;

/**
 * 面试题 03.01.动物收容所
 * <p>
 * https://leetcode.cn/problems/animal-shelter-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
class LCI0306 {

  LinkedList<int[]> stack;

  public LCI0306() {
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
