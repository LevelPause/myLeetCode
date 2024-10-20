package com.hyperboat.daily.y2024.m10.d21

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun smallestRangeII() {
        assertEquals(0,Solution().smallestRangeII(intArrayOf(1),0))
        assertEquals(6, Solution().smallestRangeII(intArrayOf(0,10),2))
        assertEquals(3, Solution().smallestRangeII(intArrayOf(1,3,6),3))
    }
}