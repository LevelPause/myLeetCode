package com.hyperboat.题单.面试经典150题.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _150逆波兰表达式求值 {

  /*
   * todo
   * */
  public int evalRPN(String[] tokens) {
    int n = tokens.length;
    Deque<Integer> nums = new ArrayDeque<>(n);
    int res = 0;
    for (String token : tokens) {
      if (!token.equals("+")
          && !token.equals("-")
          && !token.equals("*")
          && !token.equals("/")) {
        res = Integer.parseInt(token);
        nums.offerFirst(res);
      } else {
        int right = nums.pollFirst();
        int left = nums.pollFirst();
        int ca_ = ca_(token, left, right);
        res = ca_;
        nums.offerFirst(ca_);
      }
    }
    return res;
  }

  public int ca_(String op, int l, int r) throws RuntimeException {
    switch (op) {
      case "+":
        return l + r;
      case "-":
        return l - r;
      case "*":
        return l * r;
      case "/":
        return l / r;
      default:
        throw new RuntimeException();
    }
  }
}
