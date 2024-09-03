package com.hyperboat.题单.hot100.普通数组;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked
 * */
public class _238_除自身以外数组的乘积 {

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    ans[0] = nums[0];
    for (int i = 1; i < n; i++) {
      ans[i] = ans[i - 1]*nums[i];
    }
    System.out.println(Arrays.toString(ans));
    int postMulti = 1;
    for (int i = n - 1; i >= 0; i--) {
      ans[i] = i > 0 ? ans[i - 1] * postMulti : postMulti;
      postMulti *= nums[i];
    }
    return ans;
  }
}
