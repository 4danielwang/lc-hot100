class Solution {
    // 时间O(n) 空间O(1)
    // 把nums当作一个栈
    // 当nums[i] != val 入栈
    // stackSize记录栈大小 也是栈顶指针
    public int removeElement(int[] nums, int val) {
        int stackSize = 0;

        for(int n : nums){
            if(n != val){
                nums[stackSize++] = n;
            }
        }
        return stackSize;
    }
}