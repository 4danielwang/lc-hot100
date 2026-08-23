/**
 * @description: 初始位置在下标0，每个元素表示当前位置可以跳跃的最大长度，求到达最后一个下标(n-1)的最少跳跃次数
 */
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
            // 到达当前step最远边界，更新下一步的最远边界
            if(i == end){
                // 下一步的最远边界
                end = rightmost;
                // 最远步数+1
                steps++;
            }
        }
        return steps;

    }
}