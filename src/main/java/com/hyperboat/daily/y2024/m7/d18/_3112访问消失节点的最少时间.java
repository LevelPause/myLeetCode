package com.hyperboat.daily.y2024.m7.d18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _3112访问消失节点的最少时间 {

  //  稀疏图 用邻接表和dijkstra(迪拉杰斯特)算法
  public int[] minimumTime(int n, int[][] edges, int[] disappear) {
    List<int[]>[] g = new ArrayList[n];
    Arrays.setAll(g, i -> new ArrayList<>());
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      int length = edge[2];
      g[u].add(new int[]{v, length});
      g[v].add(new int[]{u, length});
    }
    int[] dis = new int[n];
    Arrays.fill(dis, -1);
    dis[0] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.offer(new int[]{0, 0});
    while (!pq.isEmpty()) {
      int[] p = pq.poll();
      int x = p[0];
      int dx = p[1];
      if (dx > dis[x]) {
        continue;
      }
      for (int[] item : g[x]) {
        int y = item[0];
        int newDis = dis[x] + item[1];
        if (newDis < disappear[y] && (dis[y] < 0 || newDis < dis[y])) {
          dis[y] = newDis;
          pq.offer(new int[]{y, newDis});
        }
      }
    }
    return dis;
  }

}
