package com.hyperboat.hot100.栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class _739_每日温度 {

  class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
      int n = temperatures.length;
      int[] ans = new int[n];
      Deque<Integer> dq = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        while (!dq.isEmpty() && temperatures[dq.peek()] < temperatures[i]) {
          int pop = dq.pop();
          ans[pop] = i - pop;
        }
        dq.push(i);
      }
      return ans;
    }
  }
}
