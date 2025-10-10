class Solution {
    // 时间O(n) 空间O(1)
    // 类似lc27
    // stackSize记录栈大小 也是栈顶指针
    // 用栈来记录去重后的元素，入栈条件是 nums[stackSize-2] != val
    public int removeDuplicates(int[] nums) {
        if(nums.length <2){
            return nums.length;
        }
        // 栈顶指针直接指向第三个元素 前两个直接入栈
        int stackSize = 2;
        for(int i=2;i<nums.length;i++){
            if(nums[i] != nums[stackSize -2]){
                nums[stackSize++] = nums[i];
            }
        }
        return stackSize;

    }
}