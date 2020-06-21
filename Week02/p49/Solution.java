package com.zhenran.leetcode.p49;

import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> key2Str = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> list;
            if (key2Str.containsKey(key)) {
                list = key2Str.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            key2Str.put(key, list);
        }

        List<List<String>> resultList = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: key2Str.entrySet()) {
            resultList.add(entry.getValue());
        }
        return resultList;
    }

    public static void main(String[] args) {
        String[] str = new String[]{ "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(new Solution().groupAnagrams(str));
    }
}
