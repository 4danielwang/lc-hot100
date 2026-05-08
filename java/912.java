import java.util.*;
class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(0, nums.length-1, nums);
        return nums;
    }

    public void quicksort(int left, int right, int[] nums){
        if(left<right){
            int pos = partition(left, right, nums);
            quicksort(left, pos-1, nums);
            quicksort(pos+1, right, nums);
        }
    }

    // 一轮交换
    public int partition(int left, int right, int[] nums){
        // 随机选择枢纽 数组有序时 减少时间复杂度
        int randomIndex = left + new Random().nextInt(right - left + 1);
        // 交换到left的位置
        swap(nums, left, randomIndex);

        int pivot = nums[left]; // 选定枢纽元素

        while(left<right){
            // 找到第一个小于pivot的元素，进行交换
            while(left<right && nums[right]>=pivot){
                right--;
            }
            swap(nums, left, right);

            while(left<right && nums[left]<=pivot){
                left++;
            }
           swap(nums, left, right);
        }
        nums[left]=pivot;
        return left;
    }

   private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}