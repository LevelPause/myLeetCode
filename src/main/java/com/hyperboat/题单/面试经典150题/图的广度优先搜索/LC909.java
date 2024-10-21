package com.hyperboat.题单.面试经典150题.图的广度优先搜索;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/snakes-and-ladders/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC909 {

  int n;
  int[] nums;

  public int snakesAndLadders(int[][] board) {
    n = board.length;
    if (board[0][0] != -1) {
      return -1;
    }
    nums = new int[n * n + 1];
    boolean isRight = true;
    for (int i = n - 1, idx = 1; i >= 0; i--) {
      for (int j = (isRight ? 0 : n - 1); isRight ? j < n : j >= 0; j += isRight ? 1 : -1) {
        nums[idx++] = board[i][j];
      }
      isRight = !isRight;
    }
    return bfs();

  }

  public int bfs() {
    Deque<Integer> dq = new ArrayDeque<>();
    dq.addLast(1);
    Map<Integer, Integer> map = new HashMap<>();
    map.put(1, 0);
    while (!dq.isEmpty()) {
      int poll = dq.poll();
      int step = map.get(poll);
      if (poll == n * n) {
        return step;
      }
      for (int i = 1; i <= 6; i++) {
        int newPoll = poll + i;
        if (newPoll <= 0 || newPoll > n * n) {
          continue;
        }
        if (nums[newPoll] != -1) {
          newPoll = nums[newPoll];
        }
        if (map.containsKey(newPoll)) {
          continue;
        }
        map.put(newPoll, step + 1);
        dq.offerLast(newPoll);
      }
    }
    return -1;
  }
}
