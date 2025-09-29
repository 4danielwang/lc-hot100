class Solution {
    // 双指针 时间O(n) 空间O(1)
    // 把输入数组当作输出数组 左指针指向输出位置 右指针指向读取的输入的位置
    // left就是最后输出数组的长度
    public int removeElement(int[] nums, int val) {
        int left=0,right=0;
        int n = nums.length;
        while(right<n){
            // 如果不是需要剔除的元素 输入输出指针同时移动
            if(nums[right] != val){
                nums[left] = nums[right];
                left++;
                right++;
            }else{
                // 需要剔除 直接移动输入指针
                right++;
            }
        }
        return left;
    }
}