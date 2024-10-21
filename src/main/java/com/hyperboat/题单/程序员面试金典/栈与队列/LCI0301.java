package com.hyperboat.题单.程序员面试金典.栈与队列;

/**
 * 面试题 03.01.三合一
 * <p>
 * https://leetcode.cn/problems/three-in-one-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
class LCI0301 {

  int[][] arr;

  public LCI0301(int stackSize) {
    arr = new int[3][stackSize + 1];
  }

  public void push(int stackNum, int value) {
    if (arr[stackNum][0] == arr[stackNum].length - 1) {
      return;
    }
    arr[stackNum][++arr[stackNum][0]] = value;
  }

  public int pop(int stackNum) {
    if (arr[stackNum][0] == 0) {
      return -1;
    } else {
      return arr[stackNum][arr[stackNum][0]--];
    }
  }

  public int peek(int stackNum) {
    if (arr[stackNum][0] == 0) {
      return -1;
    } else {
      return arr[stackNum][arr[stackNum][0]];
    }
  }

  public boolean isEmpty(int stackNum) {
    return arr[stackNum][0] <= 0;
  }
}
