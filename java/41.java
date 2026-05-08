class Solution {
    // 学号从1开始 座位号从0开始
    // i是座位号 nums[i]是学号
    // 目的：让学号=座位号-1
    // 只保留座位号长度(nums.length)个学号 其他学号丢弃
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 遍历座位号 从(1-n)下标0~n-1
        for(int i=0;i<n;i++){
            // 可能会出现有重复数字 也就是学号相同
            // 学号超过座位长度的 丢弃
            // 如果当前的学号x x这个座位号（x-1）已经是x了 丢弃
            while(nums[i] >= 1 && nums[i] <=n && nums[i] != nums[nums[i]-1]){
                // 当前学号 需要转移的座位号
                int j = nums[i]-1;
                // 交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // 找到第一个不连续的座位号
        for(int i=0;i<n;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
}