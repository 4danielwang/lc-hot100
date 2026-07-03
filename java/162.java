/**
 * @description: 在数组中找到任意一个峰值元素的下标,要求时间O(logn)
 *               思路:
 *               二分查找,每次对比i和i+1的大小,如果i>i+1,当前局部下降,说明峰值在左边,否则局部上升,说明峰值在右边,缩减二分范围
 */
class Solution {
    // 时间O(logn) 空间O(1)
    public int findPeakElement(int[] nums) {
        // [left... peek ... right]
        // 二分查找 查找结束就是结果位置
        // 局部是上升的 往右找
        // 局部是下降的 往左找

        // 二分 左右都是闭区间
        int left = 0;
        int right = nums.length - 1;

        // 结束条件是left=right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // mid是局部最大值 right包含了可能的最大值
            // 缩减范围为[left...mid]
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                // 缩减范围为[mid+1...right]
                left = mid + 1;
            }
        }
        // 最后区间只剩一个值 返回谁都行
        return left;
    }
}
