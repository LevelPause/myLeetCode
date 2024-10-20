package com.hyperboat.normal.diffcult;


/**
 * @author zhangweigang
 * @date 2022年06月18日 20:13
 */
class LC1962 {

  public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
    int[] res = new int[obstacles.length];
    int[] stack = new int[obstacles.length];
    int index = -1;
    for (int i = 0; i < obstacles.length; i++) {
      if (index == -1 || stack[index] <= obstacles[i]) {
        stack[++index] = obstacles[i];
        res[i] = index + 1;
      } else {
        //二分法 在stack中找到比比obstacles[i]小的最大数, 该数对应的序列长度+1便是obstacles[i]的序列长度
        int l = 0, r = index;
        while (l < r) {
          int mid = (l + r) / 2;
          if (stack[mid] <= obstacles[i]) {
            l = mid + 1;
          } else {
            r = mid;
          }
        }
        stack[l] = obstacles[i];
        res[i] = l + 1;
      }
    }
    return res;
  }

}
