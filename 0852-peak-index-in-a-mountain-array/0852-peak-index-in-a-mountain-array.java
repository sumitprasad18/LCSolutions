class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If in ascending part, peak is on right
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } 
            // If in descending part or at peak
            else {
                high = mid;
            }
        }

        // low == high -> peak index
        return low;
    }
}