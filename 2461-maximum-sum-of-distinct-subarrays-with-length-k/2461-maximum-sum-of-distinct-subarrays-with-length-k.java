class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
     long max = 0;   // Stores maximum valid subarray sum
        long sum = 0;   // Current window sum

        // HashMap stores frequency of elements in current window
        Map<Integer, Integer> map = new HashMap<>();

        int dups = 0;   // Counts how many duplicate elements exist

        // Step 1: Build first window of size k
        for (int i = 0; i < k; i++) {

            // Get current frequency (default 0 if not present)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // Add element to sum
            sum += nums[i];

            // If frequency becomes >1, duplicate found
            if (map.get(nums[i]) == 2) {
                dups++;
            }
        }

        // If first window has no duplicates, update max
        if (dups == 0) {
            max = sum;
        }

        // Step 2: Slide the window
        for (int i = k; i < nums.length; i++) {

            int numToAdd = nums[i];       // New element entering window
            int numToRemove = nums[i-k];  // Old element leaving window

            // ---- Add new element ----
            map.put(numToAdd, map.getOrDefault(numToAdd, 0) + 1);

            // If frequency becomes 2, it created a duplicate
            if (map.get(numToAdd) == 2) {
                dups++;
            }

            // Add to sum
            sum += numToAdd;

            // ---- Remove old element ----
            if (map.get(numToRemove) == 2) {
                // If it was duplicate before removing,
                // duplicate count decreases
                dups--;
            }

            // Reduce frequency
            map.put(numToRemove, map.get(numToRemove) - 1);

            // Remove from sum
            sum -= numToRemove;

            // If frequency becomes 0, remove from map
            if (map.get(numToRemove) == 0) {
                map.remove(numToRemove);
            }

            // If no duplicates in current window, update max
            if (dups == 0) {
                max = Math.max(max, sum);
            }
        }

        // Return maximum sum of unique subarray of size k
        return max;
    }

}
