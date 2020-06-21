package Week02.p242;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] alphaMap = new int[26];
        for (char ch : s.toCharArray()) {
            alphaMap[toLowerCase(ch) - 'a'] += 1;
        }

        for (char ch : t.toCharArray()) {
            alphaMap[toLowerCase(ch) - 'a'] -= 1;
        }

        for (int cnt : alphaMap) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }

    private char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + 32);
        } else {
            return ch;
        }
    }

}