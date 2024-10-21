package com.hyperboat.题单.面试经典150题.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.cn/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC71 {

  /*
   * 好蠢的题
   * */
  public String simplifyPath(String path) {
    String[] names = path.split("/");
    Deque<String> stack = new ArrayDeque<>(names.length);
    for (String name : names) {
      if ("..".equals(name)) {
        if (!stack.isEmpty()) {
          stack.pollLast();
        }
      } else if (name.length() > 0 && !".".equals(name)) {
        stack.offerLast(name);
      }
    }
    StringBuffer sb = new StringBuffer();
    if (stack.isEmpty()) {
      sb.append("/");
    } else {
      while (!stack.isEmpty()) {
        sb.append("/");
        sb.append(stack.pollFirst());
      }
    }
    return sb.toString();
  }
}
