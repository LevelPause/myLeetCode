package com.hyperboat.daily.y2024.m10.d18

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun minOperations() {
        assertEquals(3, Solution().minOperations(intArrayOf(0, 1, 1, 1, 0, 0)))
        assertEquals(-1, Solution().minOperations(intArrayOf(0, 1, 1, 1)))
    }
}