class Solution {
    // 时间O(n) 空间O(1)
    public void rotate(int[] nums, int k) {
        // 连续反转3次数组
        // 先全部翻转
        // 然后分割成两个子数组 分别反转
        // 找到最小的k 取余
        int n = nums.length;
        k %= n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1); 
    }

    // 把nums[left...right]反转
    private void reverse(int[] nums, int left, int right){
        // 从两侧往中间移动
        while(left < right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}