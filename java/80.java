/**
 * @description: 删除有序数组中重复的元素，出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度
 * 思路：用一个栈记录去重后的元素，如果当前元素等于栈顶下方那个数（倒数第二个数），那么不能入栈（否则会有三个一样的数）
 */
class Solution {
    // 时间O(n) 空间O(1)
    public int removeDuplicates(int[] nums) {
        int stackSize = 2;
        for(int i=2;i<nums.length;i++){
            // 不能存在三个连续相同的元素
            if(nums[i] != nums[stackSize -2]){
                nums[stackSize++] = nums[i];
            }
        }
       return Math.min(stackSize, nums.length);
    }
}