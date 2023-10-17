package com.hyperboat.tobeclassified.lc0507;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例：
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 * 提示：
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class LC02 {
    public static void main(String[] args) {
        System.out.println(new LC02().findLength(new int[]{1, 85, 1, 6, 1}, new int[]{2, 1, 0, 11, 9}));
    }

    public int findLength(int[] nums1, int[] nums2) {
        return 0;
    }
}
