package com.hyperboat.题单.hot100.栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 *
 */
class LC84 {

  //    单调栈, 一次遍历确定左右边界
//    入栈规则为:在入栈前将目前栈顶所有小于当前数的都出栈
//    那么可以得到, 元素i入栈时栈顶j一定是i左侧第一个比i小的
//    由于遇到比栈顶元素小的才出栈, 所以栈顶元素j右侧第一个比j小的一定是j出栈时遍历到的元素i
  public int largestRectangleArea(int[] heights) {

    Deque<Integer> dq = new ArrayDeque<>();
    int n = heights.length;
    int[] l = new int[n];
    int[] r = new int[n];
    Arrays.fill(r, n);
    for (int i = 0; i < n; i++) {
      while (!dq.isEmpty() && heights[dq.peek()] >= heights[i]) {
        r[dq.pop()] = i;
      }
      l[i] = dq.isEmpty() ? -1 : dq.peek();
      dq.push(i);
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, (r[i] - l[i] - 1) * heights[i]);
    }
    return ans;
  }

  // 单调栈, 两次次遍历确定左右边界
  public int largestRectangleArea1(int[] heights) {
    Deque<Integer> dq = new ArrayDeque<>();
    int n = heights.length;
    int[] l = new int[n];
    int[] r = new int[n];

    for (int i = 0; i < n; i++) {
      while (!dq.isEmpty() && heights[dq.peek()] >= heights[i]) {
        dq.pop();
      }
      l[i] = dq.isEmpty() ? -1 : dq.peek();
      dq.push(i);
    }
    dq.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!dq.isEmpty() && heights[dq.peek()] >= heights[i]) {
        dq.pop();
      }
      r[i] = dq.isEmpty() ? n : dq.peek();
      dq.push(i);
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, (r[i] - l[i] - 1) * heights[i]);
    }
    return ans;
  }

}
