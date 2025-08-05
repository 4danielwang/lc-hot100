class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        // ans为满足sum >= target的窗口 不断更新找到最小值
        // 初始化比数组长度大 代表没有符合条件的子数组
        int ans=n+1; 
        // 滑动窗口左右端点
        int left=0;
        int right=0;
        int sum=0;

        // 窗口扩大
        while(right<n){
            sum+=nums[right];
            // 窗口缩小
            while(sum >= target){
                ans = Math.min(ans, right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        // 说明没找到符合条件的子数组
        return ans<=n ? ans : 0;
    }
}