package com.hyperboat.题单.hot100.普通数组;

/**
 * 189. 轮转数组
 *
 * https://leetcode.cn/problems/rotate-array/description/
 */
class LC189 {

  public void rotate(int[] nums, int k) {
    int n = nums.length;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k % n - 1);
    reverse(nums, k % n, n - 1);
  }

  public void reverse(int[] nums, int l, int r) {
    while (l < r) {
      nums[l] ^= nums[r];
      nums[r] ^= nums[l];
      nums[l] ^= nums[r];
      l++;
      r--;
    }
  }

  public void byGcd(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    int g = gcd(k, n);
    for (int i = 0; i < g; i++) {
      int curr = i;
      int pre = nums[i];
      do {
        int next = (curr + k) % n;
        int t = nums[next];
        nums[next] = pre;
        pre = t;
        curr = next;
      } while (i != curr);
    }
  }

  public int gcd(int x, int y) {
    return y > 0 ? gcd(y, x % y) : x;
  }
}
