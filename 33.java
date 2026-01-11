class Solution {
    // 时间O(n) 空间O(1)
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 二分查找 左右闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) return mid;

            // 情况 1：左半部分 [left, mid] 是有序的
            if (nums[left] <= nums[mid]) {
                // 如果 target 就在这个有序范围内，去左边找
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    // 否则去右边（无序或包含旋转点的部分）找
                    left = mid + 1;
                }
            } 
            // 情况 2：右半部分 [mid, right] 是有序的
            else {
                // 如果 target 就在这个有序范围内，去右边找
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    // 否则去左边找
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}