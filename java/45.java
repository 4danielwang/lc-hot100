class Solution {
    // 贪心
    // 时间O(n) 空间O(1)
    public int jump(int[] nums) {
        int steps = 0;
        int n = nums.length;
        int rightmost = 0; // 最远能跳的位置
        int end = 0; // 当前step的最远边界
        
        for(int i=0;i<n-1;i++){
            rightmost = Math.max(rightmost, i+nums[i]);
            // 到达当前step范围边界了
            if(i == end){
                end = rightmost;
                steps++;
            }
        }
        return steps;

    }
}