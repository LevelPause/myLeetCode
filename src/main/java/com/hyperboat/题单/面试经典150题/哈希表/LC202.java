package com.hyperboat.题单.面试经典150题.哈希表;

import java.util.HashSet;
import java.util.Set;

class LC202 {

  public boolean isHappy(int n) {
    return fastAndSlow(n);
  }

  // 方法1: 哈希数组解决死循环问题
  public boolean hash(int n) {
    Set<Integer> nums = new HashSet<>();
    while (n != 1) {
      n = sumOfSquares(n);
      if (nums.contains(n)) {
        return false;
      }
      nums.add(n);
    }
    return true;
  }

  /* 方法2；快慢指针解决死循环问题
   * 慢指针在第一步，快指针在第二步， 慢指针每次走一步, 快指针每次走两步;
   * 只要链表上有环, 那么最终快指针会追上慢指针, 也就是fast=slow;
   * 如果没有环, 最终快指针会先到达终点
   * */
  public boolean fastAndSlow(int n) {
    int slow = n;
    int fast = getNext(n);
    while (fast != 1 && fast != slow) {
      slow = getNext(slow);
      fast = getNext(getNext(fast));
    }

    return fast == 1;
  }

  public int getNext(int n) {
    int sum = 0;
    while (n > 0) {
      int x = n % 10;
      n /= 10;
      sum += x * x;
    }
    return sum;
  }

  public int sumOfSquares(int n) {
    if (n < 10) {
      return n * n;
    }
    int x = n % 10;
    return x * x + sumOfSquares(n / 10);
  }
}
