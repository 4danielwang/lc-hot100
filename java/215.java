import java.util.Random;
/**
 * @description: 返回无序数组nums中排序后的第k大的元素（不是第k个不同的元素）
 * @example: [3,2,1,5,6,4] -> 2
 * @example: [3,2,3,1,2,4,5,5,6] -> 4
 */
class Solution {
    // 时间O(n) 空间O(1)

    private final Random random = new Random();

    // 快速选择+三路划分 把中间等于pivot的元素一次性剥离，判断目标索引在哪个区间
    public int findKthLargest(int[] nums, int k) {
        // 我们要找第 k 大，即升序排序后的索引为 n - k
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            // 1. 随机选取 pivot 避免极端情况（有序数组 时间复杂度的退化）
            int pivotIndex = left + random.nextInt(right - left + 1);
            int pivot = nums[pivotIndex];

            // 2. 原地三路划分 每次while结束后被划分为如下的3个区间
            // [left, lt-1]: 小于pivot
            // [gt+1, right]: 大于pivot
            // [lt, gt]: 等于pivot
            // i: 当前扫描的指针
            int lt = left;
            int i = left;
            int gt = right;

            while (i <= gt) {
                if (nums[i] < pivot) {
                    // 发现比 pivot 小的数：
                    // 把它扔到左边 lt 的位置，然后 lt 和 i 都往前走一步（此时lt和i都是小于pivot）
                    swap(nums, lt++, i++);
                } else if (nums[i] > pivot) {
                    // 发现比 pivot 大的数：
                    // 把它扔到右边 gt 的位置，gt往左退一步，i不自增（此时gt大于pivot但是i不确定,下一轮接着判断）
                    swap(nums, i, gt--);
                } else {
                    // 发现和 pivot 相等的数： 留在中间，i 继续往前探路
                    i++;
                }
            }

            // 3. 判断目标索引在哪个区间
            if (target >= lt && target <= gt) {
                return nums[lt]; // 目标正好在等于区域,返回最小下标
            } else if (target < lt) {
                right = lt - 1;  // 目标在左侧小于区域，抛弃右边，去左边继续找
            } else {
                left = gt + 1;   // 目标在右侧大于区域，抛弃左边，去右边继续找
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