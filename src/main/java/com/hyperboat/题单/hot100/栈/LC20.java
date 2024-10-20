package com.hyperboat.题单.hot100.栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 * <p>
 * https://leetcode.cn/problems/valid-parentheses/description/
 */
class LC20 {

  public boolean isValid(String s) {
    Deque<Character> dq = new LinkedList<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        dq.push(c);
      } else if (c == ')') {
        if (dq.isEmpty() || dq.pop() != '(') {
          return false;
        }
      } else if (c == ']') {
        if (dq.isEmpty() || dq.pop() != '[') {
          return false;
        }
      } else if (c == '}') {
        if (dq.isEmpty() || dq.pop() != '{') {
          return false;
        }
      }
    }
    return dq.isEmpty();
  }

}
