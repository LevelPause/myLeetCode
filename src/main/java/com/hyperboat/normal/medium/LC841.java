package com.hyperboat.normal.medium;

import java.util.List;

public class LC841 {

  boolean[] visit;
  int num;

  //  进房间是单项的，不能用并查集查连通量，要用搜索
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int n = rooms.size();
    visit = new boolean[n];
    num = 0;
    dfs(rooms, 0);
    return num == n;
  }

  public void dfs(List<List<Integer>> rooms, int index) {
    visit[index] = true;
    num++;
    for (Integer i : rooms.get(index)) {
      if (!visit[i]) {
        dfs(rooms, i);
      }
    }
  }
}
