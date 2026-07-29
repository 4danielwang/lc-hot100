/**
 * @description: 二分查找
 * 思路：开区间查找
 */
class Solution {
    // 时间O(logn) 空间O(1)
    public int search(int[] nums, int target) {
        int i = lowerBound(nums, target);
        // 找到i判断是否等于target
        return i < nums.length && nums[i] == target ? i : -1;
    }

    // 找到nums中第一个>=target的下标
    private int lowerBound(int[] nums, int target){
        // 循环不变量：
        // nums[left] < target
        // nums[right] >= target
        // 开区间 (left, right) 结束条件为left+1=right
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target){ // 应该往右边区间找
                left = mid;
            } else {
                right = mid;
            }
        }
        return right; // 或left+1
    }
}