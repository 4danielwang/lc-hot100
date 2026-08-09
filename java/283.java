/**
 * @description: nums数组中把0移动到数组末尾，非0元素的相对顺序不变
 * 思路：双指针，left指针指向已经处理好的序列尾部，right指针指向当前待处理序列头部
 */
class Solution {
    
    // 时间O(n) 空间O(1)
    public void moveZeroes(int[] nums) {
        int left=0;
        int right=0;
        
        // right从0开始到n-1，找非0元素，找到后和left指针交换，left指针向后移动
        while(right<nums.length){
            // 找到非0
            if(nums[right]!=0){
                // 交换快慢指针位置的元素
                swap(nums, left, right);
                // 找到一个非零，left指针向后移动
                left++;
            }
            // 没找到非0 继续找
            right++;
        }
    
    }

    private void swap(int[] nums, int i ,int j){
        int t = nums[i];
        nums[j] = nums[i];
        nums[i] = t;
    }
}