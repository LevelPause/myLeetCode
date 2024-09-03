package com.hyperboat.题单.面试经典150题.图的广度优先搜索;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _127单词接龙 {


  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    return doubleBfs(beginWord, endWord, wordList);

  }

  public int doubleBfs(String beginWord, String endWord, List<String> wordList) {
    //注意去重
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) {
      return 0;
    }
    int size = beginWord.length();
    Map<String, Integer> forwardMap = new HashMap<>();
    Map<String, Integer> backMap = new HashMap<>();

    Deque<String> forwardDq = new ArrayDeque<>();
    Deque<String> backDq = new ArrayDeque<>();

    forwardDq.push(beginWord);
    backDq.push(endWord);

    forwardMap.put(beginWord, 1);
    backMap.put(endWord, 1);
    while (!forwardDq.isEmpty() && !backDq.isEmpty()) {
      int forwardSize = forwardDq.size();
      int backSize = backDq.size();
      Deque<String> currDq;
      Map<String, Integer> currMap;
      Map<String, Integer> anotherMap;
      if (forwardSize <= backSize) {
        currDq = forwardDq;
        currMap = forwardMap;
        anotherMap = backMap;
      } else {
        currDq = backDq;
        currMap = backMap;
        anotherMap = forwardMap;
      }
      int dqSize = Math.min(forwardSize, backSize);

      for (int k = 0; k < dqSize; k++) {
        String poll = currDq.pollFirst();
        int step = currMap.get(poll);

        for (int i = 0; i < size; i++) {

          for (char j = 0; j < 26; j++) {
            char[] oldChars = poll.toCharArray();
            char newChar = (char) ('a' + j);
            if (oldChars[i] == newChar) {
              continue;
            }
            oldChars[i] = newChar;
            String newStr = new String(oldChars);
            if (!wordSet.contains(newStr)) {
              continue;
            }
            if (currMap.containsKey(newStr)) {
              continue;
            }
            if (anotherMap.containsKey(newStr)) {
              return step + anotherMap.get(newStr);
            }
            currMap.put(newStr, step + 1);
            currDq.offerLast(newStr);
          }
          //hbo->hbw->qbw->qbx
          // hbo->abo->abq
          //qbx->qbq->abq
        }
      }
    }
    return 0;
  }

  public int bfs(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    if (!set.contains(endWord)) {
      return 0;
    }
    int size = beginWord.length();
    Map<String, Integer> map = new HashMap<>();
    Deque<String> dq = new ArrayDeque<>();
    dq.push(beginWord);
    map.put(beginWord, 1);
    while (!dq.isEmpty()) {
      String poll = dq.poll();
      int step = map.get(poll);
      for (int i = 0; i < size; i++) {
        for (char j = 0; j < 26; j++) {
          char[] oldChars = poll.toCharArray();
          char newChar = (char) ('a' + j);
          if (oldChars[i] == newChar) {
            continue;
          }
          oldChars[i] = newChar;
          String newStr = new String(oldChars);
          if (!set.contains(newStr)) {
            continue;
          }
          if (map.containsKey(newStr)) {
            continue;
          }
          if (newStr.equals(endWord)) {
            return step + 1;
          }
          map.put(newStr, step + 1);
          dq.offer(newStr);
          //hbo->hbw->qbw->qbx
        }
      }
    }
    return 0;
  }
}
