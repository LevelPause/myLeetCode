package com.hyperboat.daily.y2024.m10.d20

import kotlin.math.max

class Solution {
    fun smallestRangeI(nums: IntArray, k: Int): Int {
        return max(nums.max()-nums.min()-k*2,0)
    }
}