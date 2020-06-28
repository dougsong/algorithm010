package Week03.p47;

import java.util.*;

/**
 * @author songzheng
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        Arrays.sort(nums);

        backtrack(0, nums, list, new boolean[nums.length], new ArrayDeque<>(nums.length), resultList);
        return resultList;
    }

    private void backtrack(int level, int[] nums, List<Integer> list, boolean[] used, Deque<Integer> path, List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }

            used[i] = true;
            path.addLast(nums[i]);

            backtrack(level + 1, nums, list, used, path, result);
            used[i] = false;
            path.removeLast();
        }
    }
}
