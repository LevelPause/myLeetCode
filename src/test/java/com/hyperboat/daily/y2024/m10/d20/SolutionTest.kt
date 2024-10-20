package com.hyperboat.daily.y2024.m10.d20

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun smallestRangeI() {
        assertEquals(0,Solution().smallestRangeI(intArrayOf(1),0))
        assertEquals(6,Solution().smallestRangeI(intArrayOf(0,10),2))
        assertEquals(0,Solution().smallestRangeI(intArrayOf(1,3,6),3))
    }
}