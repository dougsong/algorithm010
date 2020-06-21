package com.zhenran.leetcode.p347;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[] {};
        }

        Map<Integer, Integer> value2CntMap = new HashMap<>(nums.length);
        // O(n)
        for (int num : nums) {
            if (value2CntMap.containsKey(num)) {
                value2CntMap.put(num, value2CntMap.get(num) + 1);
            } else {
                value2CntMap.put(num, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = value2CntMap.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        // 平均O(n)
        heap.addAll(entries);

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> e = heap.poll();
            arr[i] = e.getKey();
        }

        return arr;
    }
}
