package com.hyperboat.题单.hot100.栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class _394_字符串解码 {

  class Solution {

    public String decodeString(String s) {
      Deque<String> dq = new ArrayDeque<>();
      char[] chars = s.toCharArray();
      for (char c : chars) {
        if (c != ']') {
          dq.push(String.valueOf(c));
          continue;
        }
        StringBuilder str = new StringBuilder();
        String curr = dq.pop();
        while (!curr.equals("[")) {
          str.insert(0, curr);
          curr = dq.pop();
        }
        StringBuilder num = new StringBuilder();
        while (isDigit(dq.peek())) {
          curr = dq.pop();
          num.insert(0, curr);
        }
        int step = Integer.parseInt(num.toString());
        StringBuilder push = new StringBuilder();
        for (int i = 0; i < step; i++) {
          push.append(str);
        }
        dq.push(push.toString());
      }

      StringBuilder res = new StringBuilder();
      while (!dq.isEmpty()) {
        res.append(dq.pollLast());
      }
      return res.toString();
    }

    private boolean isDigit(String str) {
      if (str == null || str.length() == 0) {
        return false;
      }
      char[] chars = str.toCharArray();
      for (char c : chars) {
        if (!Character.isDigit(c)) {
          return false;
        }
      }
      return true;
    }
  }
}
