package com.hyperboat.normal.simple;

/**
 * @author zhangweigang
 * @date 2023年10月23日
 */
class LC2678 {

  public int countSeniors(String[] details) {
    int res = 0;
    for (String detail : details) {
      if ((detail.charAt(11) - '0') * 10 + detail.charAt(12) - '0' > 60) {
        res++;
      }
    }
    return res;
  }

}
