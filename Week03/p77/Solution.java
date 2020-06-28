package Week03.p77;

import java.util.*;

/**
 * @author songzheng
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, n, k, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int level, int n, int k, LinkedList<Integer> list, List<List<Integer>> resultList) {
        if (list.size() == k) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        for (int i = level; i <= n; i++) {
            list.add(i);
            dfs(i + 1, n, k, list, resultList);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}
