package com.hyperboat.题单.面试经典150题.数组_字符串;

/**
 * @author zhangweigang
 * @date 2023年10月20日 6:12
 */
public class _238除自身以外数组的乘积 {

  //时间复杂度O(n) 空间复杂度O(n) 主要思路是将步骤拆开, 先计算元素i左边的乘积, 再计算元素i右边的乘积, 最后再合并相乘
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    //l[i]表示i元素的左侧所有元素积
    int[] l = new int[n];
    //r[i]表示i元素的右侧所有元素积
    int[] r = new int[n];
    l[0] = 1;
    r[n - 1] = 1;
    for (int i = 1; i < n; i++) {
      l[i] = nums[i - 1] * l[i - 1];
    }
    for (int i = n - 2; i >= 0; i--) {
      r[i] = nums[i + 1] * r[i + 1];
    }
    for (int i = 0; i < n; i++) {
      ans[i] = l[i] * r[i];
    }
    return ans;
  }

  // 优化, 节省了开辟L数组和R数组的空间
  // 先将预置结果数组存放i左边的乘积, 再在遍历计算右边乘积时将左边乘积一起合并, 这样遍历结束后即可得结果
  public int[] productExceptSelf1(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    ans[0] = 1;
    for (int i = 1; i < n; i++) {
      ans[i] = nums[i - 1] * ans[i - 1];
    }
    int temR = 1;
    for (int i = n - 2; i >= 0; i--) {
      temR = nums[i + 1] * temR;
      ans[i] = ans[i] * temR;
    }
    return ans;
  }
}
