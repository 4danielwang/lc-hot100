class Solution {
    // 贪心算法: 如果x可达,x+1,x+2...x+nums[x]都可达
    // 时间O(n) 空间O(1)
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0; // 能到达的最远位置

        for(int i=0;i<n;i++){
            if(i <= rightmost){
                rightmost = Math.max(rightmost, i+nums[i]);
                // 整个数组都可达 提前结束
                if(rightmost >= n-1){
                    return true;
                }
            }
        }
        // 如果当前i超过可达范围 直接返回false
        return false;
    }
}