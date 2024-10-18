package com.hyperboat.题单.dp._3_背包._3_4_分组背包

import java.math.BigInteger

/*
 * https://leetcode.cn/problems/minimize-the-difference-between-target-and-chosen-elements/description/
 */
class _1981_最小化目标值与所选元素的差 {
    internal inner class Solution {
        fun minimizeTheDifference(mat: Array<IntArray>, target: Int): Int {
            var f = BigInteger.ONE
            for (row in mat) {
                var g = BigInteger.ZERO
                for (x in row) {
                    g = g.or(f.shiftLeft(x))
                }
                f = g
            }
            var d = 0
            while (true) {
                if (f.testBit(target + d) || target > d && f.testBit(target - d)) {
                    return d
                }
                d++
            }
        }
    }
}