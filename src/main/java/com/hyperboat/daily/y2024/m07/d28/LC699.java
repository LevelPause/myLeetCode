package com.hyperboat.daily.y2024.m07.d28;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.cn/problems/falling-squares/
 * */
class LC699 {

  public List<Integer> fallingSquares(int[][] positions) {
    return normal(positions);
  }

  //  暴力枚举, 将先前的每个方块的高度有序存起来, 从大到小确认是否与当前方块重合, 更新高度
  public List<Integer> normal(int[][] positions) {
    int n = positions.length;
    List<Integer> ans = new ArrayList<>();
    ans.add(positions[0][1]);
    LinkedList<int[]> pres = new LinkedList<>();
    pres.add(new int[]{0, positions[0][1]});
    for (int i = 1; i < n; i++) {
      // 当前方块
      int[] curr = positions[i];
      int toEndHigh = curr[1];
      // 上一次最高高度
      int lastHighest = ans.get(i - 1);
      boolean toEnd = true;
      int size = pres.size();
      // 向前艺高度顺序从大到小比对是否落在了方块上
      for (int j = size - 1; j >= 0; j--) {
        //待对比方块的下标
        int highestIndex = pres.get(j)[0];
        // 待对比方块所处高度
        int high = pres.get(j)[1];
        // 待对比方块
        int[] position = positions[highestIndex];
        // 如果两个方块区间重合，说明落在该方块上了，则更新高度和dp
        if (!(curr[0] >= position[0] + position[1]
            || curr[0] + curr[1] <= position[0])) {

          int currHigh = high + curr[1];
          ans.add(i, Math.max(currHigh, lastHighest));
          addToList(i, currHigh, pres);
          toEnd = false;
          break;
        }
      }
      if (toEnd) {
        ans.add(i, Math.max(toEndHigh, lastHighest));
        addToList(i, toEndHigh, pres);
      }
    }
    return ans;

  }

  public void addToList(int i, int currHigh, List<int[]> pres) {
    int size = pres.size();
    boolean isLast = true;
    for (int k = size - 1; k >= 0; k--) {
      if (currHigh > pres.get(k)[1]) {
        pres.add(k + 1, new int[]{i, currHigh});
        isLast = false;
        break;
      }
    }
    if (isLast) {
      pres.add(0, new int[]{i, currHigh});
    }
  }
}
