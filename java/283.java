import java.util.*;

class Solution {
     // 方法1:把nums当成栈用
    public void moveZeroes(int[] nums) {
        int stackSize = 0; // 栈大小
        for(int num : nums){
            if(num != 0){
                nums[stackSize++] = num;
            }
        }
        Arrays.fill(nums, stackSize, nums.length, 0);
    }

    // 方法2:双指针
    // 0代表空位
    // 慢指针指向当前的空位
    // 快指针找到非0
    // 交换快慢指针
    public void moveZeroes2(int[] nums) {
        int slow=0;
        int fast=0;
        
        // 快指针用于扫描非0
        while(fast<nums.length){
            // 找到非0
            if(nums[fast]!=0){
                // 交换快慢指针位置的元素
                swap(nums, slow, fast);
                // 慢指针存储空位 0元素
                slow++;
            }
            // 没找到非0 继续找
            fast++;
        }
    
    }

    private void swap(int[] nums, int i ,int j){
        int t = nums[i];
        nums[j] = nums[i];
        nums[i] = t;
    }
}