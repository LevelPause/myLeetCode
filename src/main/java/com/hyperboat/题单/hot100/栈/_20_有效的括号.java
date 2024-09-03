package com.hyperboat.题单.hot100.栈;

import java.util.Deque;
import java.util.LinkedList;

public class _20_有效的括号 {

  class Solution {

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
}
