package com.hyperboat.题单.dp._3_背包._3_4_分组背包

/**
 * 2218. 从栈中取出K个硬币的最大面值和
 *
 * https://leetcode.cn/problems/maximum-value-of-k-coins-from-piles/description/
 */
class LC2218 {
    internal class Solution {
        fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {
            val n = piles.size
            // dp[i][j] 表示 前 i 个数组中取 j 个的最大值，返回值 dp[n][k]
            val dp = Array(n + 1) { IntArray(k + 1) }
            dp[0][0] = 0
            for (i in 1..n) {
                for (j in 1..k) {
                    // sum 就是前缀和
                    var sum = 0
                    var kk = 0
                    while (kk <= piles[i - 1].size && kk <= j) {
                        dp[i][j] = dp[i][j].coerceAtLeast(dp[i - 1][j - kk] + sum)
                        if (kk < piles[i - 1].size) {
                            sum += piles[i - 1][kk]
                        }
                        kk++
                    }
                }
            }
            return dp[n][k]
        }
    }
}