class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid = (low + high) / 2;

        //loop
        while (low <= high) {
            //compare target with mid value
            if (target == nums[mid]) {
                //target found
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                //target < arr[mid]
                high = mid - 1;
            }
            //update mid
            mid =(low+high)/2;

        }
        //target not found
        return -1;
    }
}