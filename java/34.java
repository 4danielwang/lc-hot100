/**
 * @description: 在排序数组中查找元素的第一个和最后一个位置, 不存在返回-1
 * 思路：二分查找，利用lowerbound函数分别找到第一个和最后一个>=target的下标。最后一个>=target下标等于lowerbound(target+1)-1
 * @example: 输入：nums = [5,7,7,8,8,10], target = 8 输出：[3,4]
 * @example: 输入：nums = [5,7,7,8,8,10], target = 6 输出：[-1,-1]
 */
class Solution {
    // 时间O(logn) 空间O(1)
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if(start == nums.length || nums[start] != target) return new int[]{-1, -1};
        int end = lowerBound(nums, target + 1) - 1; // start存在end一定存在
        return new int[]{start, end};
    }

    // 开区间找到第一个大于等于target的下标
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

        // 循环结束后 left+1 = right
        // 此时 nums[left] < target 而 nums[right] >= target
        // 所以 right 就是第一个 >= target 的元素下标
        return right; // 或left+1
    }

}