package com.hyperboat.daily.y2024.m10.d21

import java.util.*

internal class Solution {
    fun smallestRangeII(nums: IntArray, k: Int): Int {
        val n = nums.size
        Arrays.sort(nums)
        var ans = nums[n - 1] - nums[0]
        for (i in 0 until n - 1) {
            val x = nums[i]
            val y = nums[i + 1]
            val max = (nums[n - 1] - k).coerceAtLeast(x + k)
            val min = (nums[0] + k).coerceAtMost(y - k)
            ans = ans.coerceAtMost(max - min)
        }
        return ans
    }
}