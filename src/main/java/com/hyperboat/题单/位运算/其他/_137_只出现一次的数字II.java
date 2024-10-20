package com.hyperboat.题单.位运算.其他;

class _137_只出现一次的数字II {

  class Solution {

    //按位计数mod3, 计数3的会变成0, 计数1的还是1, 逐位或起来即可
    public int singleNumber(int[] nums) {
      var ans = 0;
      for (int i = 0; i < 32; i++) {
        var cnt = 0;
        for (int x : nums) {
          cnt += x >> i & 1;
        }
        ans |= (cnt % 3) << i;
      }
      return ans;
    }
  }
}
