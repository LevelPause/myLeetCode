package com.hyperboat.daily.y2024.m07.d15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class _721账户合并 {

  //  并查集
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    List<List<String>> ans = new ArrayList<>();
    if (accounts.size() == 0) {
      return ans;
    }
    Map<String, Integer> emailToIndex = new HashMap<>();
    Map<String, String> emailToName = new HashMap<>();
    int emai_ount = 0;
    for (List<String> account : accounts) {
      String name = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        String emailItem = account.get(i);
        if (!emailToIndex.containsKey(emailItem)) {
          emailToIndex.put(emailItem, emai_ount++);
          emailToName.put(emailItem, name);
        }
      }
    }

    UnionFind uf = new UnionFind(emai_ount);
    for (List<String> account : accounts) {
      int firstIndex = emailToIndex.get(account.get(1));
      for (int i = 2; i < account.size(); i++) {
        int nextIndex = emailToIndex.get(account.get(i));
        uf.union(firstIndex, nextIndex);
      }
    }

    Map<Integer, List<String>> indexToEmails = new HashMap<>();
    for (Entry<String, Integer> item : emailToIndex.entrySet()) {
      int index = uf.find(item.getValue());
      String email = item.getKey();
      List<String> emails = indexToEmails.getOrDefault(index, new ArrayList<>());
      emails.add(email);
      indexToEmails.put(index, emails);
    }
    for (List<String> emails : indexToEmails.values()) {
      Collections.sort(emails);
      String name = emailToName.get(emails.get(0));
      List<String> account = new ArrayList<>();
      account.add(name);
      account.addAll(emails);
      ans.add(account);
    }
    return ans;
  }

  class UnionFind {

    int[] parent;

    public UnionFind(int n) {
      parent = new int[n];
      for (int i = 0; i < parent.length; i++) {
        parent[i] = i;
      }
    }

    public int find(int index) {
      if (parent[index] != index) {
        parent[index] = find(parent[index]);
      }
      return parent[index];
    }

    public void union(int index1, int index2) {
      parent[find(index1)] = find(index2);
    }
  }
}

