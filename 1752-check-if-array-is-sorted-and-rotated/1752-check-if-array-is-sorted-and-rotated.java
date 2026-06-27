class Solution {
    public boolean check(int[] nums) {
        int count = 0; // counts how many times order breaks

        for(int i = 0; i < nums.length; i++) {

            /*
             Compare current element with next element.
             Use modulo (%) to make array circular.
             
             Example:
             last index -> next becomes first index
            */
            if(nums[i] > nums[(i + 1) % nums.length]) {
                count++;
            }

            /*
             If order breaks more than once,
             it cannot be sorted and rotated
            */
            if(count > 1) {
                return false;
            }
        }

        // valid if 0 or 1 break
        return true;
    }
}