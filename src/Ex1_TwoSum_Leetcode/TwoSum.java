package Ex1_TwoSum_Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: TemaC26
 * Author: mihai
 * Date: 2/25/2020
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }



    public static void main(String[] args) {

    }
}
