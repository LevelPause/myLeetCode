package com.hyperboat.竞赛.周赛412;

public class Q2_统计近似相等数对I {

  static class Solution {

    public int countPairs(int[] nums) {
      int n = nums.length;
      int ans = 0;
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (isSimilar(nums[i], nums[j])) {
            ans++;
          }
        }
      }
      return ans;
    }

    private boolean isSimilar(int i, int j) {
      if (i == j) {
        return true;
      }
      int lenI = 32 - Integer.numberOfLeadingZeros(i);
      int lenJ = 32 - Integer.numberOfLeadingZeros(j);
      int len = Math.max(lenI, lenJ);
      int diffCount = 0;
      int[][] diff = new int[2][2];
      while (len-- > 0) {
        if (j % 10 != i % 10) {
          if (++diffCount > 4) {
            break;
          }
          diff[diffCount - 1][0] = i % 10;
          diff[diffCount - 1][1] = j % 10;
        }
        j /= 10;
        i /= 10;
      }
      if (diffCount == 2) {
        if (diff[0][0] == diff[1][1] && diff[1][0] == diff[0][1]) {
          return true;
        }
      } else if (diffCount == 0) {
        return true;
      }
      return false;
    }
  }


}
