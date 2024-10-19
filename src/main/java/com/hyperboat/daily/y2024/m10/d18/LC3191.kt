package com.hyperboat.daily.y2024.m10.d18

class Solution {
    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        var ans = 0
        for (i in 0 until n - 2) {
            if (nums[i] == 0) { // 必须操作
                nums[i + 1] = nums[i + 1] xor 1
                nums[i + 2] = nums[i + 2] xor 1
                ans++
            }
        }
        return if (nums[n - 2] != 0 && nums[n - 1] != 0) ans else -1
    }
}