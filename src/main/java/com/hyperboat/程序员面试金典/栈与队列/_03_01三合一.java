package com.hyperboat.程序员面试金典.栈与队列;

public class _03_01三合一 {

  int[][] arr;

  public _03_01三合一(int stackSize) {
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
