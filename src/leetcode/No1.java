package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class No1 {
    public static void main(String[] args) {
        int[] arr = {2, 7, -11, 15};
        int target = -9;
        String s = null;
        int[] ans = twoSum_solution2(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    // 36ms
    public static int[] twoSum_1(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }

    // 20ms
    public static int[] twoSum_2(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return null;
    }

    // https://leetcode.com/problems/two-sum/discuss/3/Accepted-Java-O(n)-Solution
    // 3ms
    public static int[] twoSum_solution(int[] nums, int target) {
        // int[] arr = {2, 7, -11, 16, 10, -1, -3, 18};
        // int target = 4;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static int[] twoSum_solution2(int[] nums, int target) {
        // 2, 7, -11, 15
        // -9
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // {2 = 0}
        // {7 = 1}
        // {-11 = 2}
        // {15 = 4}
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // c = -9 - 2 = -11
            // c = -9 - 7 = -16
            // c = -9 - 11 = -20
            // c = -9 - 15 = -24
            if (map.containsKey(complement) && map.get(complement) != i) {

                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
