package com.hyperboat.题单.面试经典150题.栈;

import java.util.Stack;

/*
 * https://leetcode.cn/problems/valid-parentheses/?envType=study-plan-v2&envId=top-interview-150
 * */
class _20有效的括号 {

  public boolean isValid(String s) {
    Stack<Character> chars = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == ')' && (chars.size() == 0 || chars.pop() != '(')) {
        return false;
      }
      if (c == '}' && (chars.size() == 0 || chars.pop() != '{')) {
        return false;
      }
      if (c == ']' && (chars.size() == 0 || chars.pop() != '[')) {
        return false;
      }
      if (c != '}' && c != ']' && c != ')') {
        chars.push(c);
      }
    }
    return chars.size() == 0;
  }
}
