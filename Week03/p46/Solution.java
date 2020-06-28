package Week03.p46;

import java.util.*;

/**
 * @author songzheng
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        backtrack(0, nums, list, resultList);
        return resultList;
    }

    private void backtrack(int level, int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = level; i < nums.length; i++) {
            Collections.swap(list, i, level);
            backtrack(level + 1, nums, list, result);
            Collections.swap(list, i, level);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
}
