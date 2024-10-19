package com.hyperboat.daily.y2024.m10.d19

internal class Solution {
    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        var ans = 0
        for (i in 0 until n) {
            if (ans and 1 xor nums[i] == 0) {
                ans++
            }
        }
        return ans
    }
}