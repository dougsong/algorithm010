package Week02.p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> value2IndexMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (value2IndexMap.containsKey(find)) {
                return new int[] { i, value2IndexMap.get(find) };
            }
            value2IndexMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("Not found");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}