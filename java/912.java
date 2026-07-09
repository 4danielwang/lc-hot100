
/**
 * @description: 实现快速排序
 */
class Solution {
    // 时间复杂度O(nlogn) 空间复杂度O(logn~n)
    public int[] sortArray(int[] nums) {
        quicksort(0, nums.length - 1, nums);
        return nums;
    }

    public void quicksort(int left, int right, int[] nums) {
        if (left < right) {
            int pos = partition(left, right, nums);
            quicksort(left, pos - 1, nums);
            quicksort(pos + 1, right, nums);
        }
    }

    // 一轮交换
    public int partition(int left, int right, int[] nums) {
        // 随机选择枢纽 数组有序时 减少时间复杂度
        int randomIndex = left + new Random().nextInt(right - left + 1);
        // 交换到left的位置
        swap(nums, left, randomIndex);

        int pivot = nums[left]; // 选定随机枢纽元素

        while (left < right) {
            // 从右到左扫描, 找到第一个小于pivot的元素，进行交换
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            swap(nums, left, right);

            // 从左到右扫描, 找到第一个大于pivot的元素，进行交换
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        // 最终left和right相遇，交换枢纽元素到中间位置
        nums[left] = pivot;
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}