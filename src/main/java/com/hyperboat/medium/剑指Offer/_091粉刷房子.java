package com.hyperboat.medium.剑指Offer;

/**
 * @author zhangweigang
 * @date 2022年06月25日 21:20
 * <p>
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * <p>
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个n x 3的正整数矩阵 costs 来表示的。
 * <p>
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2]表示第 1 号房子粉刷成绿色的花费，以此类推。
 * <p>
 * 请计算出粉刷完所有房子最少的花费成本。
 */
public class _091粉刷房子 {

  public int minCost(int[][] costs) {
    int houseCount = costs.length;
    int results[] = new int[houseCount];
    backTracing(0, costs, results);

    int res = 0;
    for (int it : results) {
      res += it;
    }
    return res;
  }

  private void backTracing(int index, int[][] costs, int[] results) {
    int colorSum = costs[index].length;
    for (int i = 0; i < colorSum; i++) {

    }
  }
}
