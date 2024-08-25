package com.hyperboat.normal.tobeclassified.strstr;


/**
 * @author hyperboat
 * @date 2022年03月16日 22:27
 */
public class Solution {


  public int strStr(String haystack, String needle) {
    if (needle.equals("")) {
      return 0;
    }
    int begin = 0;
    int end = 0;
    char[] haystackChars = haystack.toCharArray();
    char[] needleChars = needle.toCharArray();
    while (end < haystack.length()) {
      if (haystackChars[end] == needleChars[end - begin]) {
        if (end - begin + 1 == needleChars.length) {
          return begin;
        }
        end++;
      } else {
        begin++;
        end = begin;
      }
    }
    return -1;
  }

  public int kmpStr(String haystack, String needle) {
    int haystackLength = haystack.length();
    int needleLength = needle.length();
    if (needleLength == 0) {
      return 0;
    }
    int[] next = new int[needleLength];
    for (int right = 1, left = 0; right < needleLength; right++) {
      while (left > 0 && needle.charAt(right) != needle.charAt(left)) {
        left = next[left - 1];
      }
      if (needle.charAt(right) == needle.charAt(left)) {
        left++;
      }
      next[right] = left;
    }
    for (int index = 0, index2 = 0; index < haystackLength; index++) {
      while (index2 > 0 && haystack.charAt(index) != needle.charAt(index2)) {
        index2 = next[index2 - 1];
      }
      if (haystack.charAt(index) == needle.charAt(index2)) {
        index2++;
      }
      if (index2 == needleLength) {
        return index - index2 + 1;
      }
    }
    return -1;
  }
}