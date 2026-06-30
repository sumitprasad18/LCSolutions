import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int no = target - nums[i];

            // check if complement exists
            if (map.containsKey(no)) {
                return new int[]{map.get(no), i};
            }

            // store current element with index
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}