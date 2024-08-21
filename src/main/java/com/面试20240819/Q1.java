package com.面试20240819;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

/*   题目: 计算比222_222_22小的前1000个素数
 * 1.面试时要求用多线程实现并行计算，在一分钟内得到结果
 * 2.面试要考察的重点是多线程的同步, 所以多线程用到的求素数方法为O(n²)
 *
 * 3.但这个求区间素数问题实际可以优化到O(n),也就是线性求解。
 * 4.线性求解的方法名为欧拉筛,是完全线性的, 不会重复枚举
 * 5.与其相似的还有埃式筛, 不过性能会差一点, 会出现重复枚举的情况
 * 6.线性筛的基本原理就是: 一个合数总能表示成比它小的两个数的乘积, 因此从小到大枚举, 将能表示为乘积的数标记为合数, 剩下的就是素数了
 * */
public class Q1 {

  public int[] compute(int num) {
    boolean[] flags = new boolean[num + 1];
    int[] prime = new int[num];
    int k = 0;
    for (int i = 2; i < num + 1; i++) {
      if (!flags[i]) {
        prime[k++] = i;
      }
      for (int index = 0; index < k && i * prime[index] <= num; index++) {
        flags[i * prime[index]] = true;
        if (i % prime[index] == 0) {
          break;
        }
      }
    }
    //收集前1000个素数
    int[] ans = new int[1000];
    int index = 0;
    for (int i = num; i > 1; i--) {
      if (index > 999) {
        break;
      }
      if (!flags[i]) {
        ans[index++] = i;
      }
    }
    return ans;
  }


  public static boolean isPrime(int n) {
    for (int i = n - 1; i >= Math.sqrt(n); i--) {
      if (n % i == 0) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    long l = System.currentTimeMillis();
    Q1 q1 = new Q1();
    System.out.println(Arrays.toString(q1.compute(222_222_22)));
    System.out.println((System.currentTimeMillis() - l));
//    ThreadPoolExecutor ex = new ThreadPoolExecutor(4,30,60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100),new CallerRunsPolicy());
  }
}
