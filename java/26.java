class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        // 最后返回slow+1，默认slow指向0，但是实际上长度是1
        int slow = 0; // 慢指针
        // 快指针不断的往前走
        for(int fast=0;fast<n;fast++){
            if(nums[slow] != nums[fast]){
                // 只有当快慢指针不相等 慢指针前进 把快指针的值赋值
                nums[++slow] = nums[fast];
            }
        }
        return slow+1;
    }
}