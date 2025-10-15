class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // prevents overflow

            if (nums[mid] == target) {
                return mid;
            }

            // Check which half is sorted
            if (nums[low] <= nums[mid]) { 
                // Left half is sorted
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // target lies in left half
                } else {
                    low = mid + 1; // target lies in right half
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1; // target lies in right half
                } else {
                    high = mid - 1; // target lies in left half
                }
            }
        }
        return -1;
    }
}
