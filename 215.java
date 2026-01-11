import java.util.Random;

class Solution {
    private final Random random = new Random();

    // 时间O(n) 空间O(1)
    // 快速选择算法的三路划分
    public int findKthLargest(int[] nums, int k) {
        // 我们要找第 k 大，即升序排序后的索引为 n - k
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            // 1. 随机选取 pivot 避免极端情况
            int pivotIndex = left + random.nextInt(right - left + 1);
            int pivot = nums[pivotIndex];

            // 2. 原地三路划分
            // lt: 小于 pivot 区域的边界
            // gt: 大于 pivot 区域的边界
            // i: 当前扫描的指针
            int lt = left;
            int i = left;
            int gt = right;

            while (i <= gt) {
                if (nums[i] < pivot) {
                    // 小于pivot与lt交换 lt边界扩大
                    swap(nums, lt++, i++);
                } else if (nums[i] > pivot) {
                    // 大于pivot与gt交换 gt边界扩大
                    swap(nums, i, gt--);
                } else {
                    // 等于pivot 边界不变
                    i++;
                }
            }

            // 划分后：
            // [left, lt-1] < pivot
            // [lt, gt] == pivot
            // [gt+1, right] > pivot

            // 3. 判断目标索引在哪个区间
            if (target >= lt && target <= gt) {
                return nums[lt]; // 目标正好在等于区域
            } else if (target < lt) {
                right = lt - 1;  // 目标在左侧小于区域
            } else {
                left = gt + 1;   // 目标在右侧大于区域
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}