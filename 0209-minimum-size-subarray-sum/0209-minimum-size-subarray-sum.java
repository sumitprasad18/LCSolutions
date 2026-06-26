class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        // Store the minimum length found
        // Start with a very large value
        int minLength = Integer.MAX_VALUE;

        // This will store the current window sum
        int sum = 0;

        // Two pointers for sliding window
        int left = 0;   // start of window
        int right = 0;  // end of window

        // Expand the window until right reaches the end
        while (right < nums.length) {

            // Add current element into window sum
            sum += nums[right];

            // If window sum is enough (>= target),
            // try to shrink it from the left
            while (sum >= target) {

                // Update minimum length
                // (right - left + 1) = current window size
                minLength = Math.min(minLength, right - left + 1);

                // Remove leftmost element from sum
                // because we are shrinking the window
                sum -= nums[left];

                // Move left pointer forward
                left++;
            }

            // Expand window by moving right pointer
            right++;
        }

        // If no valid subarray was found,
        // minLength will still be Integer.MAX_VALUE
        // so return 0
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }

        // Otherwise return the smallest subarray length found
        return minLength;
    }
}