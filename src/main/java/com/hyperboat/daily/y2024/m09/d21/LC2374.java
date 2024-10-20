package com.hyperboat.daily.y2024.m09.d21;

class LC2374 {

  class Solution {

    public int edgeScore(int[] edges) {
      long[] inDegree = new long[100001];
      int max = 0;
      for (int i = 0; i < edges.length; i++) {
        int edge = edges[i];
        inDegree[edge] += i;
        if (inDegree[edge] > inDegree[max] || inDegree[edge] == inDegree[max] && edge < max) {
          max = edge;
        }
      }
      return max;
    }
  }
}
