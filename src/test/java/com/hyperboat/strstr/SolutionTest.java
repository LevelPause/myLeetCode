package com.hyperboat.strstr;


import com.hyperboat.tobeclassified.strstr.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * @author zhangweigang
 * @date 2022年06月18日 20:13
 */
public class SolutionTest {

  @Test
  public void test() {
    // System.out.println(new Solution().strStr("aaaac", "ac"));

    System.out.println(333 & (-333));
  }

  @Test
  public void test2() {
    System.out.println(Arrays
        .toString(longestObstacleCourseAtEachPosition(new int[]{3,1,5,6,4,2})));
    //1,1,2,3,2,2
  }

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
      System.out.println(i + "  res: " + Arrays.toString(res));
      System.out.println(i + "  stack: " + Arrays.toString(stack));
    }
    return res;
  }

}
