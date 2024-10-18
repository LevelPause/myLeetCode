package com.hyperboat.daily.y2024.m07.d21;

//  https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/
public class LC1186 {

  //弄懂这个个基础是先学会求连续最大子数组(Kadane‘s算法): https://blog.csdn.net/weixin_43764974/article/details/134513506
//  核心是dp[i] 表示以arr[i]结尾的最大子数组和，那么dp[i]的表示就只有两种可能
//  1. dp[i] = dp[i-1]+arr[i]  ,这种是直接拼接之前的数组
//  2. dp[i] = arr[i]   .当dp[i-1]<0的时候, 直接放弃前面的数组, 以当前元素为此时的最大和
//  因此dp[i] = max(dp[i-1]+arr[i],arr[i]) 或者表示成: dp[i] = max(dp[i-1],0) + arr[i]
  public int maximumSum(int[] arr) {
//    因为在递推过程中, 当前状态只和前一个状态有关, 所以二维dp数组dp[i][0]和dp[i][1]就简化成了dp0和dp1
//    dp0表示不删除元素时的当前最大子数组和
    int dp0 = arr[0];
//    dp1表示删除一个元素时的当前最大子数组和
    int dp1 = 0;
//    i = 1时, 因为题目要求最少要一个元素, 所以ans只能时dp0
    int ans = dp0;
    for (int i = 1; i < arr.length; i++) {
//      当选择删除一个元素时, 就出现了两种情况：
//      1. 删除dp中的元素: 那就只能选dp[i-1][1] , 这时候就不能舍弃i之前的dp和了, 如果舍弃, 就不符合删除一个元素的情况了, 所以只能时dp[i-1][1]+arr[i];
//      2. 删除arr[i]: 这时候只能选dp[i-1][o], 并且不能舍弃, 舍弃了就剩空数组了, 不符合题意, 所以只能时dp[i-1][0];
//      最后两者取最大值即得到: Math.max(dp1 + arr[i], dp0);
      dp1 = Math.max(dp1 + arr[i], dp0);
//      当选择不删除元素时, 只能从前面不删除元素的dp中找, 也就是dp[i-1][0], 这时候套用求连续最大子数组的公式即得到 dp0 = Math.max(dp0 + arr[i], arr[i]);
      dp0 = Math.max(dp0 + arr[i], arr[i]);
//      全局更新一下最大和即可
      ans = Math.max(ans, Math.max(dp0, dp1));
    }
    return ans;
  }
}
